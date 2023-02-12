package com.renarosantos.ecommerceapp.domain.repo

import com.renarosantos.ecommerceapp.domain.model.Product
import com.renarosantos.ecommerceapp.domain.model.ProductDetails

interface ProductRepository {
    suspend fun getProductList() : List<Product>

    suspend fun getProductDetailsById(productId : String) : ProductDetails
}