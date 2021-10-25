package com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResults(

    @SerializedName("id")
    val id: String,

    @SerializedName("movie_id")
    val movieId: Int,

    @SerializedName("key")
    val key: String,

    @SerializedName("site")
    val site: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("official")
    val official: Boolean,

    @SerializedName("type")
    val type: String,

    @SerializedName("published_at")
    val publishedAt: String

)
