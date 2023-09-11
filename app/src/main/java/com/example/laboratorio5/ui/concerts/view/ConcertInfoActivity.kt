//Universidad del Valle de Guatemala
//Programación de Plataformas Móviles
//Sección 20
//Mónica Salvatierra
//Carné: 22249

package com.example.laboratorio5.ui.concerts.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.laboratorio5.R

data class Concert(val imageId: Int, val title: String, val supportingText: String) //Data class para las cards

class ConcertInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent{
           MaterialTheme{
               ConcertMainApp()
           }
       }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConcertMainApp() {
    Column(                      //Contiene todos los elementos que componen a la pantalla
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))

    ) {
        TopAppBar(            //TopAppBar
            title = { Text(text = "TodoEventos") },
            actions = {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Options")
                }
            }
        )

        LazyColumn(     //Permite realizar scroll vertical para ver todos los conciertos
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item{
                Text(
                    text = "Your Favorites",  //Incluyen los conciertos que fueron agregado como "favoritos"
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.taylor_swift, title = "Taylor Swift", supportingText = "The Eras Tour"))
                    ConcertCard(concert = Concert(imageId = R.drawable.bigtimerush, title = "Big Time Rush", supportingText = "Can´t Get Enough Tour"))
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.beyonce, title = "Beyoncé", supportingText = "Reinassance Tour"))
                    ConcertCard(concert = Concert(imageId = R.drawable.jonas_brothers, title = "Jonas Brothers", supportingText = "Five Albums. One Night. The Tour"))
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "All Concerts",  //Incluye todos los conciertos
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.beyonce, title = "Beyoncé", supportingText = "Reinassance Tour"))
                    ConcertCard(concert = Concert(imageId = R.drawable.bigtimerush, title = "Big Time Rush", supportingText = "Can´t Get Enough Tour"))
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.coldplay, title = "Coldplay", supportingText = "Music of The Spheres World Tour"))
                    ConcertCard(concert = Concert(imageId = R.drawable.jonas_brothers, title = "Jonas Brothers", supportingText = "Five Albums. One Night. The Tour"))
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.taylor_swift, title = "Taylor Swift", supportingText = "The Eras Tour"))
                    ConcertCard(concert = Concert(imageId= R.drawable.the_weekend, title = "The Weekend", supportingText = "After Hours Til Dawn Stadium Tour"))
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
@Composable
fun ConcertCard(concert: Concert) {  //Cards para cada uno de los conciertos
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(220.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF0F5),
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imagePainter = rememberAsyncImagePainter(concert.imageId) //Añade la imagen por medio del Resource Manager
            Image(
                painter = imagePainter,
                contentDescription = "Concert Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(0.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(bottom = 1.dp),
                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = concert.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = concert.supportingText, fontSize = 14.sp, textAlign = TextAlign.Center)
        }
    }
}