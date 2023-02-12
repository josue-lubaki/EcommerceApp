package com.renarosantos.ecommerceapp.product_list.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_product")
data class FavoriteProductEntity(
    @PrimaryKey
    val id : String,

    @ColumnInfo(name = "product_name")
    val productName : String,
)
