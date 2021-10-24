package com.dedesaepulloh.catalogmovie.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tbl_review")
data class ReviewEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "movieId")
    val movieId: Int,

    @ColumnInfo(name = "avatar_path")
    val avatarPath: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "rating")
    val rating: Double? = null,

    @ColumnInfo(name = "username")
    val username: String? = null,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null,

    @ColumnInfo(name = "author")
    val author: String? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,

    @ColumnInfo(name = "content")
    val content: String? = null,

    @ColumnInfo(name = "url")
    val url: String? = null

) : Parcelable
