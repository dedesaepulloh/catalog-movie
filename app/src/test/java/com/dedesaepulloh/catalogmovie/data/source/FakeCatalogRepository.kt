package com.dedesaepulloh.catalogmovie.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dedesaepulloh.catalogmovie.datasource.CatalogDataSource
import com.dedesaepulloh.catalogmovie.datasource.local.LocalDataSource
import com.dedesaepulloh.catalogmovie.datasource.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.datasource.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.datasource.remote.RemoteDataSource
import com.dedesaepulloh.catalogmovie.datasource.remote.network.NetworkBoundResource
import com.dedesaepulloh.catalogmovie.datasource.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.datasource.remote.response.movie.MovieResults
import com.dedesaepulloh.catalogmovie.datasource.remote.response.review.ReviewResults
import com.dedesaepulloh.catalogmovie.datasource.remote.response.trailer.TrailerResults
import com.dedesaepulloh.catalogmovie.datasource.remote.response.vo.ApiResponse
import com.dedesaepulloh.catalogmovie.utils.AppExecutors
import com.dedesaepulloh.catalogmovie.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeCatalogRepository @Inject constructor(
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

    override fun getMovie(genreIds: Int): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResults>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getAllMovie(genreIds),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResults>>> =
                remoteDataSource.getMovie(genreIds)

            public override fun saveCallResult(data: List<MovieResults>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        genreIds,
                        response.originalTitle,
                        response.overview,
                        response.popularity,
                        response.posterPath,
                        response.releaseDate,
                        response.voteAverage,
                        response.voteCount,
                        response.backdropPath
                    )
                    movieList.add(movie)
                    localDataSource.insertMovie(movieList)
                }
            }

        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        localDataSource.getMovieById(movieId)

    override fun getTrailer(movieId: Int): LiveData<ApiResponse<List<TrailerResults>>> =
        remoteDataSource.getTrailer(movieId)

    override fun getReview(movieId: Int): LiveData<Resource<PagedList<ReviewEntity>>> {
        return object :
            NetworkBoundResource<PagedList<ReviewEntity>, List<ReviewResults>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ReviewEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(8)
                    .setPageSize(8)
                    .build()
                return LivePagedListBuilder(
                    localDataSource.getReview(movieId),
                    config
                ).build()
            }

            override fun shouldFetch(data: PagedList<ReviewEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ReviewResults>>> =
                remoteDataSource.getReview(movieId)

            public override fun saveCallResult(data: List<ReviewResults>) {
                val reviewList = ArrayList<ReviewEntity>()
                for (response in data) {
                    val review = ReviewEntity(
                        response.id,
                        movieId,
                        response.authorDetails.avatarPath,
                        response.authorDetails.name,
                        response.authorDetails.rating,
                        response.authorDetails.username,
                        response.updatedAt,
                        response.author,
                        response.createdAt,
                        response.content,
                        response.url
                    )
                    reviewList.add(review)
                    localDataSource.insertReview(reviewList)
                }
            }

        }.asLiveData()
    }


}