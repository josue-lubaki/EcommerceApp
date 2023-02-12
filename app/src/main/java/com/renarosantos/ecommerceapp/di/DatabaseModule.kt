package com.renarosantos.ecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.renarosantos.ecommerceapp.shared.data.local.EcommerceDatabase
import com.renarosantos.ecommerceapp.product_list.data.local.WishlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) : EcommerceDatabase {
        return Room
            .databaseBuilder(
                context,
                EcommerceDatabase::class.java,
                "ecommerce.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideWishlistDao(database : EcommerceDatabase) : WishlistDao = database.wishlistDao()

}