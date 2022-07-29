package com.example.myvideoproject.dao.retrofit

import com.example.myvideoproject.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api:ApiServise by lazy {
        retrofit.create(ApiServise::class.java)
    }

}