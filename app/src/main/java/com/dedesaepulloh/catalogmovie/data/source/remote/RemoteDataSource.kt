package com.dedesaepulloh.catalogmovie.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dedesaepulloh.catalogmovie.data.source.remote.network.ApiConfig
import com.dedesaepulloh.catalogmovie.data.source.remote.response.GenreResponse
import com.dedesaepulloh.catalogmovie.data.source.remote.response.genre.GenresItem
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
}