package com.renarosantos.ecommerceapp.wishlist.data.repository

import com.renarosantos.ecommerceapp.product_list.data.local.FavoriteProductEntity
import com.renarosantos.ecommerceapp.product_list.data.local.WishlistDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WishlistRepositoryImpl @Inject constructor(
    private val wishlistDao : WishlistDao
): WishlistRepository {

    override suspend fun isFavorite(productId: String): Boolean {
        return withContext(Dispatchers.IO){
            wishlistDao.isProductFavorite(productId) != null
        }
    }

    override suspend fun addToWishlist(productId: String) {
        return withContext(Dispatchers.IO){
            wishlistDao.addProductToFavorites(
                FavoriteProductEntity(
                    id = productId,
                    productName = "",
                )
            )
        }
    }

    override suspend fun removeWishlist(productId: String) {
        return withContext(Dispatchers.IO){
            wishlistDao.removeProductFromFavorites(
                FavoriteProductEntity(
                    id = productId,
                    productName = "",
                )
            )
        }
    }
}