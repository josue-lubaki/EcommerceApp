package com.renarosantos.ecommerceapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id : String,
    val title : String,
    val description : String,
    val price : Double,
    val imageUrl : String
)
