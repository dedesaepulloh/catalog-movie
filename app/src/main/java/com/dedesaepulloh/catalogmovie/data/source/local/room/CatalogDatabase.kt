package com.dedesaepulloh.catalogmovie.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.TrailerEntity

@Database(
    entities = [GenreEntity::class, MovieEntity::class, TrailerEntity::class, ReviewEntity::class],
    version = 7,
    exportSchema = false
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}