package com.dedesaepulloh.catalogmovie.presentation.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.utils.Resource

class GenreViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getGenres(): LiveData<Resource<PagedList<GenreEntity>>> =
        catalogRepository.getGenre()
}