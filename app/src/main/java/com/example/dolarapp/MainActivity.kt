package com.example.dolarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dolarapp.ui.theme.DolarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DolarAppTheme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dolar app"
                    )
                }
            )
        },
        modifier=Modifier.fillMaxSize()
    ){
        innerPadding ->
            //Contenido del scaffold
    }
}