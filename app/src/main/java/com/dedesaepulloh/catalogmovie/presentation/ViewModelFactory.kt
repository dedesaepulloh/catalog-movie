package com.dedesaepulloh.catalogmovie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedesaepulloh.catalogmovie.repository.CatalogRepository
import com.dedesaepulloh.catalogmovie.di.AppScope
import com.dedesaepulloh.catalogmovie.presentation.genre.GenreViewModel
import com.dedesaepulloh.catalogmovie.presentation.movie.MovieViewModel
import com.dedesaepulloh.catalogmovie.presentation.detail.DetailViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val mCatalogRepository: CatalogRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(GenreViewModel::class.java) -> {
                GenreViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mCatalogRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mCatalogRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}