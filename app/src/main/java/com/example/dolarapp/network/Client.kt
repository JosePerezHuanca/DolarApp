package com.example.dolarapp.network

import retrofit2.Retrofit
import  retrofit2.converter.gson.GsonConverterFactory


object  Client{
    private  const val APIURL="https://dolarapi.com"

    private val retrofit:Retrofit by lazy{
        Retrofit.Builder()
        .baseUrl(APIURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val apiService: ApiService by  lazy {
        retrofit.create(ApiService::class.java)
    }
}