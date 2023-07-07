package com.gy25m.retrofittraining

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class RetrofitHelper {
    companion object{
        fun getinstance(): Retrofit {
                var retrofit= Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/todos/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }

}