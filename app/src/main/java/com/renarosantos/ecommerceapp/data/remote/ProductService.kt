package com.renarosantos.ecommerceapp.data.remote

import com.renarosantos.ecommerceapp.data.entities.ProductDetailsEntity
import com.renarosantos.ecommerceapp.data.entities.ProductEntity
import com.renarosantos.ecommerceapp.domain.model.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
    suspend fun getProductList() : List<ProductEntity>

    @GET("productDetails")
    suspend fun getProductDetailsById(@Query("productId") productId: String): ProductDetailsEntity

}