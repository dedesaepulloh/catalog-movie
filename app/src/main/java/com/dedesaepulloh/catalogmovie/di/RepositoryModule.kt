@file:Suppress("unused")

package com.dedesaepulloh.catalogmovie.di

import com.dedesaepulloh.catalogmovie.datasource.CatalogDataSource
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(catalogRepository: CatalogRepository): CatalogDataSource
}