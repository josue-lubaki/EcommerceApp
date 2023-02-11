package com.renarosantos.ecommerceapp.di

import com.renarosantos.ecommerceapp.data.remote.ProductService
import com.renarosantos.ecommerceapp.data.repo.ProductRepositoryImpl
import com.renarosantos.ecommerceapp.domain.repo.ProductRepository
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