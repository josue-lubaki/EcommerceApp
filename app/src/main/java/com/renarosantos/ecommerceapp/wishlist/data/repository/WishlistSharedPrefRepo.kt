package com.renarosantos.ecommerceapp.wishlist.data.repository

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class WishlistSharedPrefRepo @Inject constructor(
    context: Context
) : WishlistRepository {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_FILE_WISHLIST, Context.MODE_PRIVATE
    )

    override suspend fun isFavorite(productId: String): Boolean {
        with(sharedPref) {
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            return favorites!!.contains(productId)
        }
    }

    override suspend fun addToWishlist(productId: String) {
        with(sharedPref) {
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            mutableSetOf<String>().run {
                this.addAll(favorites!!.toList())
                this.add(productId)
                sharedPref.edit().putStringSet(KEY_FAVORITES_SET, this).apply()
            }
        }
    }

    override suspend fun removeWishlist(productId: String) {
        with(sharedPref) {
            val favorites = getStringSet(KEY_FAVORITES_SET, emptySet())
            mutableSetOf<String>().run {
                this.addAll(favorites!!.toList())
                this.remove(productId)
                sharedPref.edit().putStringSet(KEY_FAVORITES_SET, this).apply()
            }
        }
    }

    companion object {
        const val SHARED_PREFS_FILE_WISHLIST = "com.renarosantos.ecommerceapp.wishlist"
        const val KEY_FAVORITES_SET = "KEY_FAVORITES_SET"
    }
}