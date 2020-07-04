package com.example.vk_lk_finalexamsagency.DataLoader

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object Dataloader {
    var retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("http://127.0.0.1:8000/api/")
        .build()

    var service: ApiRetrofit = retrofit.create<ApiRetrofit>(ApiRetrofit::class.java)
    fun getRequest(path: String, CustomCallback: CustomCallback) {
        val call = service.getRequest(path)
        call.enqueue(Callback(CustomCallback))

    }
    private fun Callback(CustomCallback : CustomCallback) = object : Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            d("error","${t.message}")
        }
        override fun onResponse(call: Call<String>, response: Response<String>) {

            CustomCallback.onSuccess(response.body().toString())
        }

    }
}
interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") user: String?): Call<String>
}