package com.renarosantos.ecommerceapp.product_list.presentation

sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    data class Error(val message : String) : ProductListViewState()
}

fun ProductListViewState.Content.updateFavoriteProduct(
    productId : String,
    isFavorite : Boolean
) : ProductListViewState.Content {
    return ProductListViewState.Content(productList = this.productList.map { viewState ->
        if(viewState.id == productId) {
            viewState.copy(isFavorite = isFavorite)
        } else {
            viewState
        }
    })
}