package com.example.dolarapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dolarapp.viewmodel.DolarViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    val  dolarViewModel: DolarViewModel = viewModel()
    val dolar=dolarViewModel.dolar.observeAsState()
    val itemsOption= listOf("Oficial","Blue","Tarjeta","Bolsa","Cripto","Contado con liquidación","Mayorista")
    var dropdownExpanded by dolarViewModel.dropdownExpanded
    var selected by dolarViewModel.selected
    val loading by dolarViewModel.loading
    val error by dolarViewModel.errorMessage

    //Formateando fecha con simpleDateFormat. EEEE nombre del día de la semana, (Sin mayúsculas muestra abreviado), d número de día(dd para mostrar con ceros), MMMM nombre del mes (MM número del mes y sin mayúsculas minutos) yyyy año, HH hora con formato de 24, hh formato de 12, mm minutos
    val dateFormat= SimpleDateFormat("EEEE d 'de' MMMM 'del' yyyy HH:mm", Locale.getDefault())
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
        modifier= Modifier.fillMaxSize()
    ){
        innerPadding ->
        Box(
            modifier= Modifier.padding(innerPadding)
        ){
            Text(
                text = "Cotización del dolar en Argentina",
                modifier = Modifier.fillMaxWidth()
                .semantics { heading() },
                style = MaterialTheme.typography.headlineSmall
            )
            Column (
                modifier = Modifier.align(Alignment.Center) //Alinear la columna al centro de la pantalla
                .fillMaxSize()
            ){
                if(loading){
                    Box(
                        modifier=Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator(
                            modifier=Modifier
                            .size(56.dp)
                            .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
                            color = MaterialTheme.colorScheme.primary, // Color consistente con el tema
                            strokeWidth = 4.dp
                        )
                    }
                }
                else if(error){
                    Box(
                        modifier=Modifier.fillMaxWidth()
                        .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "Hubo un error al obtener los datos.",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                else{
                    dolar.value?.let {
                        Row (
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            //El modifier .weigth sirve para distribuir el espacio disponible de forma proporcional en este caso de los elementos dentro del Row
                            Text("Moneda",modifier = Modifier.weight(1f))
                            Text(it.moneda, modifier = Modifier.weight(2f))
                        }
                        Row (
                            modifier= Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text("Casa", modifier = Modifier.weight(1f))
                            Text(it.casa, modifier = Modifier.weight(2f))
                        }
                        Row (
                            modifier= Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text("Nombre", modifier = Modifier.weight(1f))
                            Text(it.nombre, modifier = Modifier.weight(2f))
                        }
                        Row (
                            modifier= Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text("Compra", modifier = Modifier.weight(1f))
                            Text(it.compra.toString(), modifier = Modifier.weight(2f))
                        }
                        Row (
                            modifier= Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text("Venta", modifier = Modifier.weight(1f))
                            Text(it.venta.toString(), modifier = Modifier.weight(2f))
                        }
                        Row (
                            modifier= Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text("Fecha actualización",modifier = Modifier.weight(1f))
                            Text(dateFormat.format(it.fechaActualizacion),modifier = Modifier.weight(2f))
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f)) //Espacio entre el contenido de Column y el Row con los botones
            }
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
            ){
                Row (
                    modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
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
                            dolarViewModel.getDolar(selected)
                        },
                        //Desavilitar el botón mientras se obtienen los datos
                        enabled = !loading
                    ){
                        Text(
                            if(error) "Reintentar"
                            else "Consultar"
                        )
                    }
                }
            }
        }
    }
}