package com.dedesaepulloh.catalogmovie.datasource.remote.response.review

import com.google.gson.annotations.SerializedName

data class ReviewResponse<T>(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<T?>? = null,

    @field:SerializedName("total_results")
    val totalResults: Int
)
