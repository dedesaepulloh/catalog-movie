package com.dedesaepulloh.catalogmovie.data.source.local

import androidx.paging.DataSource
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.room.CatalogDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mCatalogDao: CatalogDao) {
    fun getAllGenre(): DataSource.Factory<Int, GenreEntity> = mCatalogDao.getGenre()
    fun insertGenre(genre: List<GenreEntity>) = mCatalogDao.insertGenre(genre)
}