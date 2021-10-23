package com.dedesaepulloh.catalogmovie.di

import com.dedesaepulloh.catalogmovie.data.source.CatalogDataSource
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(catalogRepository: CatalogRepository): CatalogDataSource
}