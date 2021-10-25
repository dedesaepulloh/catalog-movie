package com.dedesaepulloh.catalogmovie.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.TrailerEntity

@Dao
interface CatalogDao {

    @Query("SELECT * FROM tbl_genre")
    fun getGenre(): DataSource.Factory<Int, GenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genre: List<GenreEntity>)

    @Query("SELECT * FROM tbl_movie WHERE genre_ids = :genreIds")
    fun getMovie(genreIds: Int): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE movieId = :movieId")
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Query("SELECT * FROM tbl_trailer WHERE movieId = :movieId")
    fun getTrailer(movieId: Int): LiveData<TrailerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrailer(trailer: List<TrailerEntity>)

    @Query("SELECT * FROM tbl_review WHERE movieId = :movieId")
    fun getReview(movieId: Int): DataSource.Factory<Int, ReviewEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReview(review: List<ReviewEntity>)

}