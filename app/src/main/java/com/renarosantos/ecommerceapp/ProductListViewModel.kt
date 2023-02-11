package com.renarosantos.ecommerceapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductListViewModel : ViewModel() {

    private var _viewState = MutableLiveData<ProductListViewState>()
    val viewState : LiveData<ProductListViewState> = _viewState

    init {
        loadProductList()
    }

    private fun loadProductList(){
        _viewState.postValue(ProductListViewState.Loading)
        // data call to fetch products
        _viewState.postValue(ProductListViewState.Content((1..5).map {
            ProductCardViewState("Playstation $it", "This is a nice console! Check it out", "${200 * it} US$")
        }))
    }
}