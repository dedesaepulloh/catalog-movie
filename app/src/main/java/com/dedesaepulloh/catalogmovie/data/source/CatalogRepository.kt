package com.dedesaepulloh.catalogmovie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.data.source.local.LocalDataSource
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.data.source.remote.RemoteDataSource
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.vo.ApiResponse
import com.dedesaepulloh.catalogmovie.utils.AppExecutors
import com.dedesaepulloh.catalogmovie.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatalogRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogDataSource {

    override fun getGenre(): LiveData<Resource<PagedList<GenreEntity>>> {
        return object :
            NetworkBoundResource<PagedList<GenreEntity>, List<GenresItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<GenreEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getAllGenre(),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<GenreEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<GenresItem>>> =
                remoteDataSource.getGenre()

            public override fun saveCallResult(data: List<GenresItem>) {
                val genreList = ArrayList<GenreEntity>()
                for (response in data) {
                    val genre = response.id?.let {
                        GenreEntity(
                            it,
                            response.name
                        )
                    }
                    if (genre != null) {
                        genreList.add(genre)
                    }
                    localDataSource.insertGenre(genreList)
                }
            }

        }.asLiveData()
    }

}