package com.dedesaepulloh.catalogmovie.presentation.genre

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
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
class GenreViewModelTest {

    private lateinit var viewModel: GenreViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<GenreEntity>>>

    @Mock
    private lateinit var genrePagedList: PagedList<GenreEntity>

    @Before
    fun setUp() {
        viewModel = GenreViewModel(catalogRepository)
    }

    @Test
    fun getGenres() {
        val dummy = Resource.success(genrePagedList)
        val genre = MutableLiveData<Resource<PagedList<GenreEntity>>>()
        genre.value = dummy

        Mockito.`when`(dummy.data?.size).thenReturn(3)
        Mockito.`when`(catalogRepository.getGenre()).thenReturn(genre)

        val genreEntity = viewModel.getGenres().value?.data
        Mockito.verify(catalogRepository).getGenre()
        assertNotNull(genre)
        assertEquals(3, genreEntity?.size)

        viewModel.getGenres().observeForever(observer)
        Mockito.verify(observer).onChanged(dummy)
    }
}