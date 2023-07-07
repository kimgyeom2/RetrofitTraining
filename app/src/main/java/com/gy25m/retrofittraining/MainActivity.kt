package com.gy25m.retrofittraining

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gy25m.retrofittraining.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var con=this
        binding.vm=MyViewModel(binding.recycler,con)

        binding.btn1.setOnClickListener {
            var retrofit: Retrofit =RetrofitHelper.getinstance()
            var retrofitApiservice=retrofit.create(RetrofitApiService::class.java)
            retrofitApiservice.practice().enqueue(object : Callback<List<Practice>> {
                override fun onResponse(
                    call: Call<List<Practice>>,
                    response: Response<List<Practice>>
                ) {
                    var data = response.body()
                    Log.i("zzz",data.toString())
                    if (data != null) {
                        binding.recycler.adapter = MyAdapter(data[0].item, this@MainActivity)
                    }
                }

                override fun onFailure(call: Call<List<Practice>>, t: Throwable) {
                    Log.i("zzzz", t.message.toString())
                }


            })
        }
    }

}