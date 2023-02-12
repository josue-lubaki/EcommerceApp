package com.renarosantos.ecommerceapp.product_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository : ProductRepository,
    private val useCases: UseCases,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
    ) : ViewModel() {

    private var _viewState = MutableLiveData<ProductListViewState>()
    val viewState : LiveData<ProductListViewState> = _viewState

    init {
        loadProductList()
    }

    private fun loadProductList(){
        viewModelScope.launch(dispatcher) {
            _viewState.postValue(ProductListViewState.Loading)

            try {
                val productList = repository.getProductList()
                _viewState.postValue(
                    ProductListViewState.Content(
                    productList.map { product ->
                        ProductCardViewState(
                            id = product.id,
                            title = product.title,
                            description = product.description,
                            price = "${product.price} CAD",
                            imageUrl = product.imageUrl,
                            isFavorite = useCases.isProductInWishlistUseCase(product.id)
                        )
                    }
                ))
            } catch (e: Exception) {
                _viewState.postValue(ProductListViewState.Error(e.message ?: "Unknown error"))
            }
        }
    }

    fun favoriteIconClicked(productId: String){
        viewModelScope.launch(dispatcher) {
            useCases.addOrRemoveFromWishlistUseCase(productId)
            val currentViewState = _viewState.value
            (currentViewState as? ProductListViewState.Content)?.let { content ->
                _viewState.postValue(
                    content.updateFavoriteProduct(productId, useCases.isProductInWishlistUseCase(productId))
                )
            }
        }
    }
}