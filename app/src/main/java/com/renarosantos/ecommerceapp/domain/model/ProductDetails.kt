package com.renarosantos.ecommerceapp.domain.model

data class ProductDetails(
    val id : String,
    val title: String,
    val description: String,
    val fullDescription: String,
    val price: Double,
    val imageUrl : String,
    val pros : List<String>,
    val cons : List<String>
)