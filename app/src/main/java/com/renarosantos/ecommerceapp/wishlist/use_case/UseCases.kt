package com.renarosantos.ecommerceapp.wishlist.use_case

import com.renarosantos.ecommerceapp.wishlist.use_case.add_or_remove_product_from_wishlist.AddOrRemoveFromWishlistUseCase
import com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist.IsProductInWishlistUseCase

data class UseCases(
    val isProductInWishlistUseCase: IsProductInWishlistUseCase,
    val addOrRemoveFromWishlistUseCase: AddOrRemoveFromWishlistUseCase
)
