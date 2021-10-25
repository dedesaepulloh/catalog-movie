package com.dedesaepulloh.catalogmovie.data.source.remote.network

import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.TrailerEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.MovieResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.review.ReviewResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.review.ReviewResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    val movieEntity: MovieEntity
    val entity: TrailerEntity
    val reviewEntity: ReviewEntity

    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<GenreResponse<GenresItem>>

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("with_genres") genreIds: Int = movieEntity.genreIds
    ): Call<MovieResponse<MovieResults>>

    @GET("movie/{movie_id}/videos")
    fun getTrailer(
        @Path("movie_id") movieId: Int? = entity.movieId,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<TrailerResponse<TrailerResults>>

    @GET("movie/{movie_id}/reviews")
    fun getReview(
        @Path("movie_id") movieId: Int? = reviewEntity.movieId,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<ReviewResponse<ReviewResults>>

}