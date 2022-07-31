package com.dedesaepulloh.catalogmovie.datasource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.TrailerEntity

@Database(
    entities = [GenreEntity::class, MovieEntity::class, TrailerEntity::class, ReviewEntity::class],
    version = 8,
    exportSchema = false
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}