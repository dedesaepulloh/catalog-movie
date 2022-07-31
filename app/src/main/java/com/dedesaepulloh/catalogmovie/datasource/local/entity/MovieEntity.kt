package com.dedesaepulloh.catalogmovie.datasource.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    val movieId: Int,

    @ColumnInfo(name = "genre_ids")
    val genreIds: Int,

    @ColumnInfo(name = "original_title")
    val original_title: String? = null,

    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "popularity")
    val popularity: Double? = null,

    @ColumnInfo(name = "poster_path")
    val poster_path: String? = null,

    @ColumnInfo(name = "release_date")
    val release_date: String? = null,

    @ColumnInfo(name = "vote_average")
    val vote_average: Double? = null,

    @ColumnInfo(name = "vote_count")
    val vote_count: Double? = null,

    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String? = null

) : Parcelable

