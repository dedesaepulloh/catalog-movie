package com.dedesaepulloh.catalogmovie.ui.movie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.utils.DataDummy
import com.dedesaepulloh.catalogmovie.vo.Resource
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
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyMovie()[0]
    private val dummyReview = DataDummy.generateDummyReview()[0]
    private val movieId = dummyMovies.movieId
    private val movieIdReview = dummyReview.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerReview: Observer<Resource<PagedList<ReviewEntity>>>

    @Mock
    private lateinit var reviewPagedList: PagedList<ReviewEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogRepository)
    }

    @Test
    fun getMoviesById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovies

        Mockito.`when`(movieId.let { catalogRepository.getMovieDetail(it) }).thenReturn(movie)

        val movieEntities = movieId.let { viewModel.getMoviesById(it).value } as MovieEntity
        Mockito.verify(catalogRepository).getMovieDetail(movieId)

        assertNotNull(movieEntities)
        assertEquals(dummyMovies.movieId, movieEntities.movieId)
        assertEquals(dummyMovies.genreIds, movieEntities.genreIds)
        assertEquals(dummyMovies.original_title, movieEntities.original_title)
        assertEquals(dummyMovies.overview, movieEntities.overview)
        assertEquals(dummyMovies.popularity.toString(), movieEntities.popularity.toString())
        assertEquals(dummyMovies.poster_path, movieEntities.poster_path)
        assertEquals(dummyMovies.release_date, movieEntities.release_date)
        assertEquals(dummyMovies.vote_average.toString(), movieEntities.vote_average.toString())
        assertEquals(dummyMovies.vote_count.toString(), movieEntities.vote_count.toString())
        assertEquals(dummyMovies.backdrop_path, movieEntities.backdrop_path)

        viewModel.getMoviesById(movieId).observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun getReview() {
        val dummy = Resource.success(reviewPagedList)
        val review = MutableLiveData<Resource<PagedList<ReviewEntity>>>()
        review.value = dummy

        Mockito.`when`(dummy.data?.size).thenReturn(1)
        Mockito.`when`(catalogRepository.getReview(movieIdReview)).thenReturn(review)

        val reviewEntity = viewModel.getReview(movieIdReview).value?.data
        Mockito.verify(catalogRepository).getReview(movieIdReview)
        assertNotNull(review)
        assertEquals(1, reviewEntity?.size)

        viewModel.getReview(movieIdReview).observeForever(observerReview)
        Mockito.verify(observerReview).onChanged(dummy)
    }
}