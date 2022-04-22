package com.example.apitraining.view.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    companion object{
        fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://gorest.co.in/public/v2/")
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getClient(): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .connectTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .hostnameVerifier { _, _ -> true }
                .build()
        }
    }





}