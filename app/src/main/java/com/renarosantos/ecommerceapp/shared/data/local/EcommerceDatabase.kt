package com.renarosantos.ecommerceapp.shared.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.renarosantos.ecommerceapp.product_list.data.local.FavoriteProductEntity
import com.renarosantos.ecommerceapp.product_list.data.local.WishlistDao

@Database(entities = [FavoriteProductEntity::class], version = 1, exportSchema = false)
abstract class EcommerceDatabase : RoomDatabase(){
        abstract fun wishlistDao() : WishlistDao
}