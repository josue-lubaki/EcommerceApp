package com.renarosantos.ecommerceapp.data.repo

import com.renarosantos.ecommerceapp.ui.ProductCardViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProductRepositoryImpl {

    suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            delay(2000)
            (1..5).map {
                ProductCardViewState(
                    "Playstation $it",
                    "This is a nice console! Check it out",
                    "${200 * it} US$",
                    "https://images.unsplash.com/photo-1606144042614-b2417e99c4e3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
                )
            }
        }
    }
}