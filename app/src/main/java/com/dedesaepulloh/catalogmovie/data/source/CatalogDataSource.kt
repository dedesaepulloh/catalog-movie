package com.dedesaepulloh.catalogmovie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.vo.Resource

interface CatalogDataSource {
    fun getGenre(): LiveData<Resource<PagedList<GenreEntity>>>
}