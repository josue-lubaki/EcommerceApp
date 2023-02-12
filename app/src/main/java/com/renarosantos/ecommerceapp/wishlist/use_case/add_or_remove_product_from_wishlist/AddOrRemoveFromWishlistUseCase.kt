package com.renarosantos.ecommerceapp.wishlist.use_case.add_or_remove_product_from_wishlist

import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist.IsProductInWishlistUseCase
import javax.inject.Inject

class AddOrRemoveFromWishlistUseCase @Inject constructor(
    private val isProductInWishlistUseCase: IsProductInWishlistUseCase,
    private val wishlistRepository: WishlistRepository
) {

    suspend operator fun invoke(productId: String) {
        if (isProductInWishlistUseCase.invoke(productId)) {
            wishlistRepository.removeWishlist(productId)
        } else {
            wishlistRepository.addToWishlist(productId)
        }
    }

}