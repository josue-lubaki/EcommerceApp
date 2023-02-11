package com.renarosantos.ecommerceapp.domain.repo

import com.renarosantos.ecommerceapp.ui.ProductCardViewState

interface ProductRepository {
    suspend fun getProductList() : List<ProductCardViewState>
}