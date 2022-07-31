package com.dedesaepulloh.catalogmovie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dedesaepulloh.catalogmovie.datasource.local.LocalDataSource
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.datasource.remote.RemoteDataSource
import com.dedesaepulloh.catalogmovie.utils.AppExecutors
import com.dedesaepulloh.catalogmovie.utils.DataDummy
import com.dedesaepulloh.catalogmovie.utils.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val catalogRepository = FakeCatalogRepository(remote, local, appExecutors)

    private val genreResponse = DataDummy.generateDummyGenreResponse()

    private val movieResponse = DataDummy.generateDummyMovieResponse()
    private val movie = DataDummy.generateDummyMovie()[0]
    private val genreIds = movie.genreIds

    @Test
    fun getGenre() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, GenreEntity>
        Mockito.`when`(local.getAllGenre()).thenReturn(dataSourceFactory)
        catalogRepository.getGenre()

        val genreEntity =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyGenre()))
        verify(local).getAllGenre()
        assertNotNull(genreEntity.data)
        assertEquals(genreResponse.size.toLong(), genreEntity.data?.size?.toLong())
    }

    @Test
    fun getMovie() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getAllMovie(genreIds)).thenReturn(dataSourceFactory)
        catalogRepository.getMovie(genreIds)

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovie(genreIds)
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        Mockito.`when`(movie.movieId.let { local.getMovieById(it) }).thenReturn(dummyMovie)

        val data =
            LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movie.movieId))
        movie.movieId.let { verify(local).getMovieById(it) }

        assertNotNull(data)
        assertEquals(movie.movieId, data.movieId)
        assertEquals(movie.genreIds, data.genreIds)
        assertEquals(movie.original_title, data.original_title)
        assertEquals(movie.overview, data.overview)
        assertEquals(movie.popularity, data.popularity)
        assertEquals(movie.poster_path, data.poster_path)
        assertEquals(movie.release_date, data.release_date)
        assertEquals(movie.vote_average, data.vote_average)
        assertEquals(movie.vote_count, data.vote_count)
        assertEquals(movie.backdrop_path, data.backdrop_path)
    }
}