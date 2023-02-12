package com.renarosantos.ecommerceapp.shared.data.repository

import com.renarosantos.ecommerceapp.product_list.domain.Product
import com.renarosantos.ecommerceapp.product_details.domain.ProductDetails

interface ProductRepository {
    suspend fun getProductList() : List<Product>

    suspend fun getProductDetailsById(productId : String) : ProductDetails
}