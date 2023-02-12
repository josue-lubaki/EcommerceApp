package com.renarosantos.ecommerceapp.product_list.domain

data class Product(
    val id : String,
    val title : String,
    val description : String,
    val price : Double,
    val imageUrl : String
)
