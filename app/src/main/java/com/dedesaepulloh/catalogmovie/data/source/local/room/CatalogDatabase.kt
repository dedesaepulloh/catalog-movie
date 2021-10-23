package com.dedesaepulloh.catalogmovie.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity

@Database(
    entities = [GenreEntity::class, MovieEntity::class],
    version = 3,
    exportSchema = false
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}