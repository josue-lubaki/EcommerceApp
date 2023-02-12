package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.shared.data.remote.ProductRepositoryImpl
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepositoryImpl
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistSharedPrefRepo
import com.renarosantos.ecommerceapp.wishlist.use_case.UseCases
import com.renarosantos.ecommerceapp.wishlist.use_case.add_or_remove_product_from_wishlist.AddOrRemoveFromWishlistUseCase
import com.renarosantos.ecommerceapp.wishlist.use_case.is_product_in_wishlist.IsProductInWishlistUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

// create annotation for qualifier my provides
@Qualifier
annotation class RoomDatabase

@Qualifier
annotation class SharedPref

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(productRepositoryImpl : ProductRepositoryImpl) : ProductRepository {
        return productRepositoryImpl
    }

    // Using Room Database
    @Provides
    @Singleton
    @RoomDatabase
    fun provideWishlistRepository(wishlistRepositoryImpl: WishlistRepositoryImpl) : WishlistRepository {
        return wishlistRepositoryImpl
    }

    // Using Shared Preferences
    @Provides
    @Singleton
    @SharedPref
    fun provideWishlistSharedPrefRepository(wishlistSharedPrefRepo : WishlistSharedPrefRepo) : WishlistRepository {
        return wishlistSharedPrefRepo
    }

    @Provides
    @Singleton
    fun provideUseCases(@SharedPref wishlistRepository: WishlistRepository) : UseCases {
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