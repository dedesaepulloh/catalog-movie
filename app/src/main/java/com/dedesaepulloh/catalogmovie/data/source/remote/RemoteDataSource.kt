package com.dedesaepulloh.catalogmovie.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.network.ApiConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.MovieResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.review.ReviewResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.review.ReviewResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.trailer.TrailerResults
import com.dedesaepulloh.catalogmovie.data.source.remote.response.vo.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor() {
    fun getGenre(): LiveData<ApiResponse<List<GenresItem>>> {
        val result = MutableLiveData<ApiResponse<List<GenresItem>>>()
        ApiConfig.getApiService().getGenre()
            .enqueue(object : Callback<GenreResponse<GenresItem>> {
                override fun onResponse(
                    call: Call<GenreResponse<GenresItem>>,
                    response: Response<GenreResponse<GenresItem>>
                ) {
                    if (response.isSuccessful) {
                        result.postValue(ApiResponse.success(response.body()?.genres as List<GenresItem>))
                    }
                }

                override fun onFailure(call: Call<GenreResponse<GenresItem>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    result.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                }
            })
        return result
    }

    fun getMovie(genreIds: Int): LiveData<ApiResponse<List<MovieResults>>> {
        val result = MutableLiveData<ApiResponse<List<MovieResults>>>()
        ApiConfig.getApiService().getMovie(BuildConfig.API_KEY, genreIds)
            .enqueue(object : Callback<MovieResponse<MovieResults>> {
                override fun onResponse(
                    call: Call<MovieResponse<MovieResults>>,
                    response: Response<MovieResponse<MovieResults>>
                ) {
                    if (response.isSuccessful) {
                        result.postValue(ApiResponse.success(response.body()?.results as List<MovieResults>))
                    }
                }

                override fun onFailure(call: Call<MovieResponse<MovieResults>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    result.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                }
            })
        return result
    }

    fun getTrailer(movieId: Int): LiveData<ApiResponse<List<TrailerResults>>> {
        val result = MutableLiveData<ApiResponse<List<TrailerResults>>>()
        ApiConfig.getApiService().getTrailer(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<TrailerResponse<TrailerResults>> {
                override fun onResponse(
                    call: Call<TrailerResponse<TrailerResults>>,
                    response: Response<TrailerResponse<TrailerResults>>
                ) {
                    if (response.isSuccessful) {
                        result.postValue(ApiResponse.success(response.body()?.results as List<TrailerResults>))
                        Log.i("Response", response.toString())
                    }
                }

                override fun onFailure(call: Call<TrailerResponse<TrailerResults>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    result.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                }
            })
        return result
    }

    fun getReview(movieId: Int): LiveData<ApiResponse<List<ReviewResults>>> {
        val result = MutableLiveData<ApiResponse<List<ReviewResults>>>()
        ApiConfig.getApiService().getReview(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<ReviewResponse<ReviewResults>> {
                override fun onResponse(
                    call: Call<ReviewResponse<ReviewResults>>,
                    response: Response<ReviewResponse<ReviewResults>>
                ) {
                    if (response.isSuccessful) {
                        result.postValue(ApiResponse.success(response.body()?.results as List<ReviewResults>))
                        Log.i("Response", response.toString())
                    }
                }

                override fun onFailure(call: Call<ReviewResponse<ReviewResults>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    result.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                }
            })
        return result
    }

}