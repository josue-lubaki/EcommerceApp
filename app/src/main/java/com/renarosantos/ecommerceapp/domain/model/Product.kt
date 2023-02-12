package com.renarosantos.ecommerceapp.domain.model

data class Product(
    val id : String,
    val title : String,
    val description : String,
    val price : Double,
    val imageUrl : String
)
