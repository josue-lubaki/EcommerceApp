package com.renarosantos.ecommerceapp.data.repo

import com.renarosantos.ecommerceapp.data.remote.ProductService
import com.renarosantos.ecommerceapp.domain.repo.ProductRepository
import com.renarosantos.ecommerceapp.ui.ProductCardViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(private val service : ProductService) : ProductRepository {

    override suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            service.getProductList().map {
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