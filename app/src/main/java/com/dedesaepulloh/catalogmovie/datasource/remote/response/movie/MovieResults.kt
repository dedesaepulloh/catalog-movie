package com.dedesaepulloh.catalogmovie.datasource.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResults(

    @SerializedName("id")
    val id: Int,

    @SerializedName("genre_ids")
    val genreIds: List<Int>,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Double,

    @SerializedName("backdrop_path")
    val backdropPath: String

)
