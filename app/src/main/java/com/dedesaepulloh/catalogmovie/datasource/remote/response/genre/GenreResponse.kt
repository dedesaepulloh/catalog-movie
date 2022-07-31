package com.dedesaepulloh.catalogmovie.datasource.remote.response.genre

import com.google.gson.annotations.SerializedName

data class GenreResponse<T>(
    @field:SerializedName("genres")
    val genres: List<T?>? = null
)
