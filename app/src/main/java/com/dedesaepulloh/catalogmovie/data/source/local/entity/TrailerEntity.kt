package com.dedesaepulloh.catalogmovie.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_trailer")
data class TrailerEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "movieId")
    val movieId: Int,

    @ColumnInfo(name = "key")
    val key: String? = null,

    @ColumnInfo(name = "site")
    val site: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "type")
    val type: String? = null,

    @ColumnInfo(name = "published_at")
    val publishedAt: String? = null

) : Parcelable
