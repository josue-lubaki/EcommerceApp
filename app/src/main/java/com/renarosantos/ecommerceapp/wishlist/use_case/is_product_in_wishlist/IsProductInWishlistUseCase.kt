package com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist

import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import javax.inject.Inject

class IsProductInWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {

    suspend operator fun invoke(productId: String) : Boolean =
        wishlistRepository.isFavorite(productId)

}