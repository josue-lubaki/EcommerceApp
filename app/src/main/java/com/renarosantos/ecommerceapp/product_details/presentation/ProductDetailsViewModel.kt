package com.renarosantos.ecommerceapp.product_details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val repository : ProductRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<ProductDetailsViewState>()
    val viewState = _viewState

    fun loadProductDetailsById(productId : String){
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.postValue(ProductDetailsViewState.Loading)

            try {
                val productDetails = repository.getProductDetailsById(productId)
                _viewState.postValue(ProductDetailsViewState.Content(productDetails))
            } catch (e: Exception) {
                _viewState.postValue(ProductDetailsViewState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}