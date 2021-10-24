package com.dedesaepulloh.catalogmovie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.vo.Resource

class MovieViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> =
        catalogRepository.getMovie()
}