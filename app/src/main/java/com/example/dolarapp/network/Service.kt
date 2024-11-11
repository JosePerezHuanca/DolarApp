package com.example.dolarapp.network

import com.example.dolarapp.model.Dolar
import retrofit2.http.GET

//El propósito de la interface Service es definir cómo y a qué endpoints de la API se ban a enviar las peticiones mediante retrofit
interface ApiService{
    @GET("/v1/dolares/oficial")
    suspend fun getOficial(): Dolar
}