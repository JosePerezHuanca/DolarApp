package com.example.dolarapp.network

import com.example.dolarapp.model.Dolar
import retrofit2.http.GET
import retrofit2.Response

//El propósito de la interface Service es definir cómo y a qué endpoints de la API se ban a enviar las peticiones mediante retrofit
interface ApiService{
    @GET("/v1/dolares/oficial")
    suspend fun getOficial(): Response<Dolar>
    @GET("/v1/dolares/blue")
    suspend fun getBlue(): Response<Dolar>
    @GET("/v1/dolares/tarjeta")
    suspend fun getTarjeta(): Response<Dolar>
    @GET("/v1/dolares/bolsa")
    suspend fun getBolsa(): Response<Dolar>
    @GET("/v1/dolares/cripto")
    suspend fun getCripto(): Response<Dolar>
    @GET("/v1/dolares/contadoconliqui")
    suspend fun getCcl(): Response<Dolar>
    @GET("/v1/dolares/mayorista")
    suspend fun getMayorista(): Response<Dolar>
}