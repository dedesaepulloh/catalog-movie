package com.dedesaepulloh.catalogmovie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.vo.ApiResponse
import com.dedesaepulloh.catalogmovie.vo.Resource

interface CatalogDataSource {
    fun getGenre(): LiveData<Resource<PagedList<GenreEntity>>>
    fun getMovie(genreIds: Int): LiveData<Resource<PagedList<MovieEntity>>>
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>
    fun getTrailer(movieId: Int): LiveData<ApiResponse<List<TrailerResults>>>
    fun getReview(movieId: Int): LiveData<Resource<PagedList<ReviewEntity>>>
}