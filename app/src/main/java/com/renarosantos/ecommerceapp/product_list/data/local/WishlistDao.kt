package com.renarosantos.ecommerceapp.product_list.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishlistDao {

    @Query("SELECT * FROM favorite_product WHERE id = :productId")
    fun isProductFavorite(productId : String) : FavoriteProductEntity?

    @Insert
    fun addProductToFavorites(product : FavoriteProductEntity)

    @Delete
    fun removeProductFromFavorites(product : FavoriteProductEntity)
}