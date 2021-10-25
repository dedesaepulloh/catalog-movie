package com.dedesaepulloh.catalogmovie.ui.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.vo.Resource

class GenreViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getGenres(): LiveData<Resource<PagedList<GenreEntity>>> =
        catalogRepository.getGenre()
}