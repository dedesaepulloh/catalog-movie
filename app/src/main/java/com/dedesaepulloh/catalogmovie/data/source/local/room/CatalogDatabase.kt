package com.dedesaepulloh.catalogmovie.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity

@Database(
    entities = [GenreEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}