package com.renarosantos.ecommerceapp.ui

sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    data class Error(val message : String) : ProductListViewState()
}