package com.gy25m.retrofittraining

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MyViewModel(var re:RecyclerView,var context: Context) {

    fun callRetrofit(){
        var retrofit: Retrofit =RetrofitHelper.getinstance()
        var retrofitApiservice=retrofit.create(RetrofitApiService::class.java)
        retrofitApiservice.practice().enqueue(object : Callback<List<Practice>>{
            override fun onResponse(
                call: Call<List<Practice>>,
                response: Response<List<Practice>>
            ) {
                var data=response.body()
                if (data!=null){
                    re.adapter=MyAdapter(data[0].item,context)
                }
            }

            override fun onFailure(call: Call<List<Practice>>, t: Throwable) {
                Log.i("zzzz",t.message.toString())
            }

        })

    }

}