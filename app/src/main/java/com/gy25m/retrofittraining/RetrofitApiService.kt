package com.gy25m.retrofittraining

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApiService {
    @GET("https://jsonplaceholder.typicode.com/todos")
    fun practice():Call<List<Practice>>
}