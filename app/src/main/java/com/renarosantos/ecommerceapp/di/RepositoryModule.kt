package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.shared.data.repository.remote.ProductService
import com.renarosantos.ecommerceapp.shared.data.repository.remote.ProductRepositoryImpl
import com.renarosantos.ecommerceapp.shared.data.repository.ProductRepository
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
}