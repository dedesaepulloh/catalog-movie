package com.dedesaepulloh.catalogmovie.data.source.remote.network

import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.response.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.MovieResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.ResultsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<GenreResponse<GenresItem>>

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Call<MovieResponse<ResultsItem>>

}