package com.dedesaepulloh.catalogmovie.data.source.remote.network

import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.local.entity.TrailerEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.MovieResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.TrailerResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.ResultsItemMovie
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    val entity: TrailerEntity

    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<GenreResponse<GenresItem>>

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Call<MovieResponse<ResultsItemMovie>>

    @GET("movie/{movie_id}/videos")
    fun getTrailer(
        @Path("movie_id") movieId: Int? = entity.movieId,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<TrailerResponse<TrailerResults>>

}