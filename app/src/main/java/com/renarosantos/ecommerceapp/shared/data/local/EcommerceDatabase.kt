package com.renarosantos.ecommerceapp.shared.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteProductEntity::class], version = 1)
abstract class EcommerceDatabase : RoomDatabase(){
        abstract fun wishlistDao() : WishlistDao
}