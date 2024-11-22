package com.example.dolarapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dolarapp.model.Dolar
import com.example.dolarapp.network.Client
import kotlinx.coroutines.launch

class DolarViewModel:ViewModel () {
    private val _dolar = MutableLiveData<Dolar?>()
    val dolar: LiveData<Dolar?> get() = _dolar

    var dropdownExpanded = mutableStateOf(false)
    var selected = mutableStateOf("")
    var loading = mutableStateOf(false)
    var errorMessage= mutableStateOf(false)

    fun getDolar(type: String) {
        loading.value = true
        errorMessage.value=false
        viewModelScope.launch {
            try {
                //When para evaluar la condición de type y llamar a las acciones de Client
                val response = when (type) {
                    "Blue" -> Client.apiService.getBlue()
                    "Tarjeta" -> Client.apiService.getTarjeta()
                    "Bolsa" -> Client.apiService.getBolsa()
                    "Cripto" -> Client.apiService.getCripto()
                    "Contado con liquidación" -> Client.apiService.getCcl()
                    "Mayorista" -> Client.apiService.getMayorista()
                    else -> Client.apiService.getOficial()
                }
                if(response.isSuccessful){
                    _dolar.value = response.body()
                    loading.value = false
                }
            }
            catch (e: Exception) {
                _dolar.value = null
                loading.value=false
                errorMessage.value=true
            }
        }
    }
}