package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.product_list.data.local.WishlistDao
import com.renarosantos.ecommerceapp.shared.data.remote.ProductRepositoryImpl
import com.renarosantos.ecommerceapp.shared.data.remote.ProductService
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepositoryImpl
import com.renarosantos.ecommerceapp.wishlist.use_case.UseCases
import com.renarosantos.ecommerceapp.wishlist.use_case.add_or_remove_product_from_wishlist.AddOrRemoveFromWishlistUseCase
import com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist.IsProductInWishlistUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(service : ProductService) : ProductRepository {
        return ProductRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideWishlistRepository(wishlistDao: WishlistDao) : WishlistRepository {
        return WishlistRepositoryImpl(wishlistDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(wishlistRepository: WishlistRepository) : UseCases {
        return UseCases(
            isProductInWishlistUseCase = IsProductInWishlistUseCase(
                wishlistRepository = wishlistRepository
            ),
            addOrRemoveFromWishlistUseCase = AddOrRemoveFromWishlistUseCase(
                isProductInWishlistUseCase = IsProductInWishlistUseCase(
                    wishlistRepository = wishlistRepository
                ),
                wishlistRepository = wishlistRepository
            )
        )
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}