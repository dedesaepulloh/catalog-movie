package com.dedesaepulloh.catalogmovie.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.datasource.remote.response.trailer.TrailerResults
import com.dedesaepulloh.catalogmovie.datasource.remote.response.vo.ApiResponse
import com.dedesaepulloh.catalogmovie.utils.Resource

class DetailViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {
    fun getMoviesById(movieId: Int): LiveData<MovieEntity> =
        catalogRepository.getMovieDetail(movieId)

    fun getTrailer(movieId: Int): LiveData<ApiResponse<List<TrailerResults>>> =
        catalogRepository.getTrailer(movieId)

    fun getReview(movieId: Int): LiveData<Resource<PagedList<ReviewEntity>>> =
        catalogRepository.getReview(movieId)
}