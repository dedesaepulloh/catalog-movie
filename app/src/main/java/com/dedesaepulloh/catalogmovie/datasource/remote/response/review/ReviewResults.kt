package com.dedesaepulloh.catalogmovie.datasource.remote.response.review

import com.google.gson.annotations.SerializedName

data class ReviewResults(

    @SerializedName("id")
    val id: String,

    @SerializedName("movie_id")
    val movieId: Int,

    @SerializedName("author_details")
    val authorDetails: AuthorDetails,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("content")
    val content: String,

    @SerializedName("url")
    val url: String
)
