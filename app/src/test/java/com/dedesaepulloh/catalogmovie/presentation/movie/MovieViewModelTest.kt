package com.dedesaepulloh.catalogmovie.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.utils.DataDummy
import com.dedesaepulloh.catalogmovie.utils.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovie()[0]
    private val genreIds = dummyMovies.genreIds

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogRepository)
    }

    @Test
    fun getMovie() {
        val dummy = Resource.success(moviePagedList)
        val movie = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movie.value = dummy

        Mockito.`when`(dummy.data?.size).thenReturn(1)
        Mockito.`when`(catalogRepository.getMovie(genreIds)).thenReturn(movie)

        val movieEntity = viewModel.getMovie(genreIds).value?.data
        Mockito.verify(catalogRepository).getMovie(genreIds)
        assertNotNull(movie)
        assertEquals(1, movieEntity?.size)

        viewModel.getMovie(genreIds).observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}