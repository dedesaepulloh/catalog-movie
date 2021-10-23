package com.dedesaepulloh.catalogmovie.di

import android.content.Context
import com.dedesaepulloh.catalogmovie.data.source.CatalogDataSource
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun provideRepository(): CatalogDataSource
}