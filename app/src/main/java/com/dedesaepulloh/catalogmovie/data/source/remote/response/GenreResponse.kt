package com.dedesaepulloh.catalogmovie.data.source.remote.response

import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.google.gson.annotations.SerializedName

data class GenreResponse<T>(
    @field:SerializedName("genres")
    val genres: List<T?>? = null
)
