package com.renarosantos.ecommerceapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.domain.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository : ProductRepository) : ViewModel() {

    private var _viewState = MutableLiveData<ProductListViewState>()
    val viewState : LiveData<ProductListViewState> = _viewState

    init {
        loadProductList()
    }

    private fun loadProductList(){
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.postValue(ProductListViewState.Loading)

            try {
                val productList = repository.getProductList()
                _viewState.postValue(ProductListViewState.Content(productList))
            } catch (e: Exception) {
                _viewState.postValue(ProductListViewState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}