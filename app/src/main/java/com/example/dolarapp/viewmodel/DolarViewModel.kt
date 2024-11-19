package com.example.dolarapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dolarapp.model.Dolar
import com.example.dolarapp.network.Client
import kotlinx.coroutines.launch

class DolarViewModel:ViewModel (){
    private val _dolar = MutableLiveData<Dolar?>()
    val dolar: LiveData<Dolar?> get() = _dolar

    var selected= mutableStateOf("")
    var loading=mutableStateOf(false)


    fun getOficial(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getOficial()
                _dolar.value=response
                loading.value=false
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun  getBlue(){
        loading.value=true
        viewModelScope.launch {
            try {
                val response=Client.apiService.getBlue()
                _dolar.value=response
                loading.value=false
            }
            catch (e: Exception){
                _dolar.value=null
            }
        }
    }

    fun getTarjeta(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getTarjeta()
                _dolar.value=response
                loading.value=false
            }
            catch (e: Exception){
                _dolar.value=null
            }
        }
    }

    fun getBolsa(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getBolsa()
                _dolar.value=response
                loading.value=false
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getCripto(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getCripto()
                _dolar.value=response
                loading.value=false
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getCcl(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getCcl()
                _dolar.value=response
                loading.value=false
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getMayorista(){
        loading.value=true
        viewModelScope.launch {
            try{
                val response=Client.apiService.getMayorista()
                _dolar.value=response
                loading.value=false
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }
}