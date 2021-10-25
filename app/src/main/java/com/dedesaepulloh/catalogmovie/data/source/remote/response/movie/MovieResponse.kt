package com.dedesaepulloh.catalogmovie.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse<T>(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<T?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int
)