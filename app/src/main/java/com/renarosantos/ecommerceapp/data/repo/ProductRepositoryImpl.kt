package com.renarosantos.ecommerceapp.data.repo

import com.renarosantos.ecommerceapp.data.remote.ApiClient
import com.renarosantos.ecommerceapp.ui.ProductCardViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl {

    private val client = ApiClient().getClient()

    suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            client.getProductList().map {
                ProductCardViewState(
                    title = it.title,
                    description = it.description,
                    price = "${it.price.toInt()} CAD",
                    imageUrl = it.imageUrl
                )
            }
        }
    }
}