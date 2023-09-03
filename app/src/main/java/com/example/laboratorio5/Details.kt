//Universidad del Valle de Guatemala
//Programación de Plataformas Móviles
//Sección 20
//Mónica Salvatierra
//Carné: 22249

package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ConcertDetail(val title: String, val date: String, val time: String, val description: String)  //Data class que contiene la información de los conciertos individuales

class Details : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailsMainApp()
        }
    }
}

@Composable
fun DetailsMainApp() {
    val concert = ConcertDetail(  //Ejemplo de uno de los conciertos
        title = "The Eras Tour LA",
        date = "8/04",
        time = "20:00",
        description = "Taylor Swift's Eras Tour is a six-leg stadium tour that began on March 17, 2023. The tour supports all of Swift's studio albums, including her latest album, Midnights (2022).\n" +
                "\n" +
                "The tour has a critical and commercial success, grossing over \$2 billion worldwide. It´s the highest-grossing tour of all time by a female artist, and the second-highest-grossing tour of all time by any artist.\n" +
                "\n" +
                "The Eras Tour is a significant event in Taylor Swift's career, and it is a celebration of her music and her impact on pop culture."
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(  //Incluye la imagen añadida desde el Resource Manager como el banner
                painter = painterResource(id = R.drawable.sofistadium),
                contentDescription = "Banner Image",
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(bottom = 1.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text( //Texto con el nombre del concierto
            text = concert.title,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {  //Incluye la hora y la fecha del concierto con sus respectivos icons
            DetailItem(icon = painterResource(id =R.drawable.calendar ), text = "Fecha: ${concert.date}")
            DetailItem(icon = painterResource(id = R.drawable.access_time), text = "Hora: ${concert.time}")
        }

        Text(  //Sección About
            text = "About",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text( //Texto con la descripción del concierto
            text = concert.description,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(  //Botón favorite en la esquina inferior izquierda
                onClick = {   /* TODO */ },
                modifier=Modifier
                    .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9EA9ED), // Cambia el color de fondo aquí
                    contentColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(text = "Favorite")
            }
            Button( //Botón Buy en la esquina inferior derecha
                onClick = { /* TODO */ },
                modifier = Modifier
                    .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFF9EA9ED),
                    contentColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(text = "Buy")
            }
        }
    }
}

@Composable
fun DetailItem(icon: Painter, text: String) { //Contiene la estructura del detalle del concierto
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = LocalContentColor.current.copy(alpha = 0.6f),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}