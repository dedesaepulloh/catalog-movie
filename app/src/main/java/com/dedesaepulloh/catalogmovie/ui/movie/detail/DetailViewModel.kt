package com.dedesaepulloh.catalogmovie.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.vo.ApiResponse

class DetailViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMoviesById(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)

    fun getTrailer(movieId: Int): LiveData<ApiResponse<List<TrailerResults>>> =
        catalogRepository.getTrailer(movieId)
}