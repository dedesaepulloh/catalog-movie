package com.dedesaepulloh.catalogmovie.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.utils.Resource

class MovieViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMovie(genreIds: Int): LiveData<Resource<PagedList<MovieEntity>>> =
        catalogRepository.getMovie(genreIds)
}