package com.renarosantos.ecommerceapp.ui

import java.io.Serializable

data class ProductCardViewState(
    val title : String,
    val description : String,
    val price : String,
    val imageUrl : String
) : Serializable