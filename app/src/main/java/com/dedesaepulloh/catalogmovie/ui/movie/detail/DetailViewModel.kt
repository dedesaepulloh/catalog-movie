package com.dedesaepulloh.catalogmovie.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity

class DetailViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMoviesById(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)
}