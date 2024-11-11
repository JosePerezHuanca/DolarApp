package com.example.dolarapp.model

import java.time.LocalDateTime


//Esta clase se basa en la estructura del objeto json
data class Dolar(
    val moneda: String,
    val casa: String,
    val nombre: String,
    val compra: Double,
    val venta: Double,
    val fechaActualizacion: LocalDateTime
)