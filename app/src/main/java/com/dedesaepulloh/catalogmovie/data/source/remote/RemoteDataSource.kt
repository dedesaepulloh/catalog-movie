package com.dedesaepulloh.catalogmovie.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedesaepulloh.catalogmovie.BuildConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.network.ApiConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.response.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.MovieResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.TrailerResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
import com.dedesaepulloh.catalogmovie.data.source.remote.response.movie.ResultsItemMovie
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

    fun getMovie(): LiveData<ApiResponse<List<ResultsItemMovie>>> {
        val result = MutableLiveData<ApiResponse<List<ResultsItemMovie>>>()
        ApiConfig.getApiService().getMovie()
            .enqueue(object : Callback<MovieResponse<ResultsItemMovie>> {
                override fun onResponse(
                    call: Call<MovieResponse<ResultsItemMovie>>,
                    response: Response<MovieResponse<ResultsItemMovie>>
                ) {
                    if (response.isSuccessful) {
                        result.postValue(ApiResponse.success(response.body()?.results as List<ResultsItemMovie>))
                    }
                }

                override fun onFailure(call: Call<MovieResponse<ResultsItemMovie>>, t: Throwable) {
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
                    }
                }

                override fun onFailure(call: Call<TrailerResponse<TrailerResults>>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                    result.postValue(ApiResponse.error(t.message.toString(), mutableListOf()))
                }
            })
        return result
    }

}