package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class FavoriteConcerts(val title: String, val location: String )

class Favorites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        setContent{
            MaterialTheme{
                FavoritesMainApp()
            }
        }
    }
}

@Composable
fun FavoritesMainApp(){ //**SUBJECT TO CHANGE** //
    Column(  //Contiene la estructura de la pantalla
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F8F4FF")))
            .padding(16.dp)
    )
    {
        Text( //Título
            text = "Upcoming Shows",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        LazyColumn( //Permite que se puedan visualizar todos los lugares de los conciertos mediante un scroll vertical
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ){
            item{
                FavoritesCard( //Cards individuales que representan cada location **FALTA AGREGAR MÁS**
                    FavoriteConcerts(title = "Taylor Swift  LA", location = "So-Fi Stadium")
                )
                Spacer(modifier = Modifier.height(16.dp))

                FavoritesCard(
                    FavoriteConcerts(title = "Big Time Rush  LA", location = "Kia Forum")
                )
                Spacer(modifier = Modifier.height(16.dp))

                FavoritesCard(
                    FavoriteConcerts(title = "Beyoncé  London", location = "Wembley Stadium")
                )
                Spacer(modifier = Modifier.height(16.dp))

                FavoritesCard(
                    FavoriteConcerts(title = "Jonas Brothers  NY", location = "Madison Square Garden")
                )

            }
        }
    }
}

@Composable
fun FavoritesCard(favs: FavoriteConcerts) { //Cards para cada ubicación
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE7DEFF),
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            AIcon( //Icono de perfil con letra
                letter = favs.title.first().toString(), //La letra será el primer carácter del nombre del artista
                color = Color(0xFF9EA9ED)

            )

            Spacer(modifier = Modifier.width(16.dp))

            // Detalles del lugar
            Column {
                Text(text = favs.title, fontSize = 18.sp, color= Color.Black)
                Text(text = favs.location, fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.weight(1f))

            // Ícono de location
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun AIcon(letter: String, color: Color) { //Función que incluye la estructura del ícon para cada lugar
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(
                color,
                shape = CircleShape
            )
    ) {
        Text(
            text = letter,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}