package com.renarosantos.ecommerceapp.data.repo

import com.renarosantos.ecommerceapp.data.remote.ProductService
import com.renarosantos.ecommerceapp.domain.model.Product
import com.renarosantos.ecommerceapp.domain.model.ProductDetails
import com.renarosantos.ecommerceapp.domain.repo.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(private val service : ProductService) : ProductRepository {

    override suspend fun getProductList(): List<Product> {
        return withContext(Dispatchers.IO) {
            service.getProductList().map {
                Product(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    price = it.price,
                    imageUrl = it.imageUrl
                )
            }
        }
    }

    override suspend fun getProductDetailsById(productId: String): ProductDetails {
        return withContext(Dispatchers.IO) {
            val productDetails = service.getProductDetailsById(productId)
            ProductDetails(
                id = productDetails.id,
                title = productDetails.title,
                description = productDetails.description,
                fullDescription = productDetails.full_description,
                price = productDetails.price,
                imageUrl = productDetails.imageUrl,
                pros = productDetails.pros,
                cons = productDetails.cons
            )
        }
    }
}