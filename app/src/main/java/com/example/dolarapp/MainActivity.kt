package com.example.dolarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
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
    val itemsOption= listOf("Oficial","Blue","Tarjeta")
    var dropdownExpanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(itemsOption[0]) }
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
            Box(
                modifier=Modifier.padding(innerPadding)
                .fillMaxSize()
            ){
                Text(
                    text = "Cotización del dolar en Argentina",
                    modifier = Modifier.fillMaxWidth()
                    .semantics { heading() },
                    style = MaterialTheme.typography.headlineSmall
                )
                Row (
                    modifier = Modifier.align(Alignment.BottomCenter) //Alinear la Row al centro inferior de la pantalla
                    .fillMaxWidth()
                    .padding(bottom =64.dp), //Padding de 64 dp para suvir la Row
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        onClick = {
                            //Acción dropdown
                            dropdownExpanded=true
                        }
                    ){
                        Text(selected)
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Menú",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    DropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = {
                            dropdownExpanded=false
                        }
                    ){
                        for(option in itemsOption){
                            DropdownMenuItem(
                                text = {
                                    Text(option)
                                },
                                onClick = {
                                    selected=option
                                    dropdownExpanded=false
                                }
                            )
                        }
                    }
                    Button(
                        onClick = {
                            //acción consultar
                        }
                    ){
                        Text("Consultar")
                    }
                }
            }
    }
}