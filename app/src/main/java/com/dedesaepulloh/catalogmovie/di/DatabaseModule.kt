package com.dedesaepulloh.catalogmovie.di

import android.content.Context
import androidx.room.Room
import com.dedesaepulloh.catalogmovie.data.source.local.room.CatalogDao
import com.dedesaepulloh.catalogmovie.data.source.local.room.CatalogDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): CatalogDatabase = Room.databaseBuilder(
        context,
        CatalogDatabase::class.java, "db_catalog"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: CatalogDatabase): CatalogDao = database.catalogDao()
}