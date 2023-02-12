package com.renarosantos.ecommerceapp.wishlist.use_case.add_or_remove_product_from_wishlist

import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist.IsProductInWishlistUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AddOrRemoveFromWishlistUseCaseTest {

    private val isProductInWishlistUseCase = mockk<IsProductInWishlistUseCase>()
    private val wishlistRepository = mockk<WishlistRepository>(relaxed = true)
    private lateinit var useCase : AddOrRemoveFromWishlistUseCase

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Product is not in Wishlist, then add method is called`() = runTest {
        // Given
        coEvery { isProductInWishlistUseCase.invoke(any()) } returns false
        useCase = AddOrRemoveFromWishlistUseCase(isProductInWishlistUseCase, wishlistRepository)

        // When
        useCase.invoke("")

        // Then
        coVerify { wishlistRepository.addToWishlist(any()) }

    }

    @Test
    fun `should remove product from wishlist when it is in wishlist`() {

    }
}