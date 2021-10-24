package com.dedesaepulloh.catalogmovie.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResults(

	@SerializedName("id")
	val id: Int,

	@SerializedName("genre_ids")
	val genreIds: List<Int>,

	@SerializedName("overview")
	val overview: String,

	@SerializedName("original_language")
	val originalLanguage: String,

	@SerializedName("original_title")
	val originalTitle: String,

	@SerializedName("title")
	val title: String,

	@SerializedName("poster_path")
	val posterPath: String,

	@SerializedName("backdrop_path")
	val backdropPath: String,

	@SerializedName("release_date")
	val releaseDate: String,

	@SerializedName("popularity")
	val popularity: Double,

	@SerializedName("vote_average")
	val voteAverage: Double,

	@SerializedName("vote_count")
	val voteCount: Double
)
