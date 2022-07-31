package com.dedesaepulloh.catalogmovie.datasource.remote.response.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResponse<T>(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("results")
    val results: List<T?>? = null
)
