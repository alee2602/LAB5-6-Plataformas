
package com.example.laboratorio5.ui.concerts.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.laboratorio5.R
import com.example.laboratorio5.ui.detail.view.Details
import com.example.laboratorio5.ui.detail.view.DetailsMainApp

data class Concert( val imageId: Int, val title: String, val supportingText: String) //Data class para las cards

class ConcertInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ConcertInfoContent()
        }
    }

    @Composable
    fun ConcertInfoContent() {
        val navController = rememberNavController() //Navegación para ir de una card a un detalle

        MaterialTheme {
            NavHost(navController, startDestination = "concertMainApp") {
                composable("concertMainApp") {
                    ConcertMainApp(navController)
                }
                composable("concertDetail/{concertId}") { backStackEntry ->
                    val concertId = backStackEntry.arguments?.getString("concertId")
                    DetailsMainApp(concertId)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConcertMainApp(navController: NavController) {
    val context = LocalContext.current
    Column(      //Contiene todos los elementos que componen a la pantalla
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

        LazyColumn(  //Permite realizar scroll vertical para ver todos los conciertos
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
                    ConcertCard(concert = Concert(imageId = R.drawable.taylor_swift, title = "Taylor Swift", supportingText = "The Eras Tour"), context= context)
                    ConcertCard(concert = Concert(imageId = R.drawable.bigtimerush, title = "Big Time Rush", supportingText = "Can´t Get Enough Tour"), context= context)
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.beyonce, title = "Beyoncé", supportingText = "Reinassance Tour"), context= context)
                    ConcertCard(concert = Concert(imageId = R.drawable.jonas_brothers, title = "Jonas Brothers", supportingText = "Five Albums. One Night. The Tour"), context= context)
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "All Concerts",  //Incluye todos los conciertos
                    fontSize = 18.sp,
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
                    ConcertCard(concert = Concert(imageId = R.drawable.beyonce, title = "Beyoncé", supportingText = "Reinassance Tour"), context= context)
                    ConcertCard(concert = Concert(imageId = R.drawable.bigtimerush, title = "Big Time Rush", supportingText = "Can´t Get Enough Tour"), context= context)
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.coldplay, title = "Coldplay", supportingText = "Music of The Spheres World Tour"), context= context)
                    ConcertCard(concert = Concert(imageId = R.drawable.jonas_brothers, title = "Jonas Brothers", supportingText = "Five Albums. One Night. The Tour"),context= context)
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ConcertCard(concert = Concert(imageId = R.drawable.taylor_swift, title = "Taylor Swift", supportingText = "The Eras Tour"),  context= context)
                    ConcertCard(concert = Concert(imageId= R.drawable.wosito, title = "WOS", supportingText = "Oscuro Éxtasis Tour"), context= context)

                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
@Composable
fun ConcertCard(concert: Concert, context: Context) {  //Cards para cada uno de los conciertos
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(220.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                val intent= Intent(context, Details::class.java)
                intent.putExtra("concertId", concert.title)
                context.startActivity(intent)
            },
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

@Composable
@Preview
fun ConcertMainAppPreview(){
    val navController = rememberNavController()
    ConcertMainApp(navController)
}