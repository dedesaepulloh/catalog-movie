package com.dedesaepulloh.catalogmovie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dedesaepulloh.catalogmovie.data.source.CatalogRepository
import com.dedesaepulloh.catalogmovie.di.AppScope
import com.dedesaepulloh.catalogmovie.ui.genre.GenreViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val mCatalogRepository: CatalogRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(GenreViewModel::class.java) -> {
                GenreViewModel(mCatalogRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}