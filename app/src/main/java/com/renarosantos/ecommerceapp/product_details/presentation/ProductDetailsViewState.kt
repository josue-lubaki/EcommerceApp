package com.renarosantos.ecommerceapp.product_details.presentation

import com.renarosantos.ecommerceapp.product_details.domain.ProductDetails

sealed class ProductDetailsViewState {
    object Loading : ProductDetailsViewState()
    data class Content(val product: ProductDetails) : ProductDetailsViewState()
    data class Error(val message : String) : ProductDetailsViewState()
}
