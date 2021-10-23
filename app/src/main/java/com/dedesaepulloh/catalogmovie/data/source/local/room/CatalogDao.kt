package com.dedesaepulloh.catalogmovie.data.source.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity

@Dao
interface CatalogDao {

    @Query("SELECT * FROM tbl_genre")
    fun getGenre(): DataSource.Factory<Int, GenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genre: List<GenreEntity>)

}