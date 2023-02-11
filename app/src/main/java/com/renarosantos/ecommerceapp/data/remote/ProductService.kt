package com.renarosantos.ecommerceapp.data.remote

import com.renarosantos.ecommerceapp.domain.model.ProductEntity
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProductList() : List<ProductEntity>

}