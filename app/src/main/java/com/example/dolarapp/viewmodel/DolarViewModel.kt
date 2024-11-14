package com.example.dolarapp.viewmodel

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


    fun getOficial(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getOficial()
                _dolar.value=response
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun  getBlue(){
        viewModelScope.launch {
            try {
                val response=Client.apiService.getBlue()
                _dolar.value=response
            }
            catch (e: Exception){
                _dolar.value=null
            }
        }
    }

    fun getTarjeta(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getTarjeta()
                _dolar.value=response
            }
            catch (e: Exception){
                _dolar.value=null
            }
        }
    }

    fun getBolsa(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getBolsa()
                _dolar.value=response
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getCripto(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getCripto()
                _dolar.value=response
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getCcl(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getCcl()
                _dolar.value=response
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }

    fun getMayorista(){
        viewModelScope.launch {
            try{
                val response=Client.apiService.getMayorista()
                _dolar.value=response
            }
            catch (e:Exception){
                _dolar.value=null
            }
        }
    }
}