package com.renarosantos.ecommerceapp.product_list.presentation

sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    data class Error(val message : String) : ProductListViewState()
}