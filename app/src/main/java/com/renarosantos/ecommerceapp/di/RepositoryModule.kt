package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.shared.data.local.WishlistDao
import com.renarosantos.ecommerceapp.shared.data.remote.ProductRepositoryImpl
import com.renarosantos.ecommerceapp.shared.data.remote.ProductService
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}