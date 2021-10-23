package com.dedesaepulloh.catalogmovie.data.source.remote.response.genre

import com.google.gson.annotations.SerializedName

data class GenresItem(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null
)
