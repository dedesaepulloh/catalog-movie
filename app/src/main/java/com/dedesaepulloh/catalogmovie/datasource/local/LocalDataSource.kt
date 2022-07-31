package com.dedesaepulloh.catalogmovie.datasource.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.datasource.local.room.CatalogDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mCatalogDao: CatalogDao) {
    fun getAllGenre(): DataSource.Factory<Int, GenreEntity> = mCatalogDao.getGenre()
    fun insertGenre(genre: List<GenreEntity>) = mCatalogDao.insertGenre(genre)

    fun getAllMovie(genreIds: Int): DataSource.Factory<Int, MovieEntity> =
        mCatalogDao.getMovie(genreIds)

    fun getMovieById(movieId: Int): LiveData<MovieEntity> = mCatalogDao.getMovieDetail(movieId)
    fun insertMovie(movie: List<MovieEntity>) = mCatalogDao.insertMovie(movie)

    fun getReview(movieId: Int): DataSource.Factory<Int, ReviewEntity> =
        mCatalogDao.getReview(movieId)

    fun insertReview(review: List<ReviewEntity>) = mCatalogDao.insertReview(review)

}