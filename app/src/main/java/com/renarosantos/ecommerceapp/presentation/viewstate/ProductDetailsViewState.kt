package com.renarosantos.ecommerceapp.presentation.viewstate

import com.renarosantos.ecommerceapp.domain.model.ProductDetails

sealed class ProductDetailsViewState {
    object Loading : ProductDetailsViewState()
    data class Content(val product: ProductDetails) : ProductDetailsViewState()
    data class Error(val message : String) : ProductDetailsViewState()
}
