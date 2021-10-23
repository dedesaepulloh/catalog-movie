package com.dedesaepulloh.catalogmovie.data.source.remote.network

import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.response.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<GenreResponse<GenresItem>>
}