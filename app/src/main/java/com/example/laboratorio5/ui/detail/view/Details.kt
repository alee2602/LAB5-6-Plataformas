//Universidad del Valle de Guatemala
//Programación de Plataformas Móviles
//Sección 20
//Mónica Salvatierra
//Carné: 22249
package com.example.laboratorio5.ui.detail.view

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class ConcertDetail(
    val artist: String,
    val title: String,
    val subTitle: String,
    val date: String,
    val time: String,
    val description: String,
    val bannerResId: Int // Para que cada concierto tenga su banner individual
)

class Details : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val concertId = intent.getStringExtra("concertId")
        setContent {
            DetailsMainApp(concertId)
        }
    }
}


fun onBackPressed() { //Permite retroceder a la Activity de ConcertMainApp
    TODO("")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsMainApp(concertId: String?) {
    val detailsConcerts = listOf( //Lista con los conciertos
        ConcertDetail(
            artist = "Taylor Swift",
            title = "Taylor Swift LA",
            subTitle = "SoFi Stadium",
            date = "8/04",
            time = "20:00",
            description = "Taylor Swift's Eras Tour is a six-leg stadium tour that began on March 17, 2023. The tour supports all of Swift's studio albums, including her latest album, Midnights (2022).\n" +
                    "\n" +
                    "The tour has a critical and commercial success, grossing over \$2 billion worldwide. It´s the highest-grossing tour of all time by a female artist, and the second-highest-grossing tour of all time by any artist.\n" +
                    "\n" +
                    "The Eras Tour is a significant event in Taylor Swift's career, and it is a celebration of her music and her impact on pop culture.",
            bannerResId = com.example.laboratorio5.R.drawable.sofistadium
        ),
        ConcertDetail(
            artist = "Big Time Rush",
            title = "Big Time Rush LA",
            subTitle = "Kia Forum",
            date = "8/12",
            time = "19:00",
            description = "Big Time Rush is back for their Can't Get Enough Tour!\n" +
                    "\n" +
                    "Big Time Rush first rose to fame in 2009 with their self-titled Nickelodeon show. The show followed four hockey players from Minnesota who are recruited to form a boy band in Hollywood. The band released four studio albums and went on three world tours before disbanding in 2013.\n" +
                    "\n" +
                    "The Can't Get Enough Tour is a celebration of Big Time Rush's return. The band will be performing all of their greatest hits, as well as new music from their upcoming album. \n"+
                    "Tickets are on sale now!",
            bannerResId = com.example.laboratorio5.R.drawable.btrbanner
        ),
        ConcertDetail(
            artist = "Beyoncé",
            title = "Beyoncé London",
            subTitle = "Wembley Stadium",
            date = "8/29",
            time = "20:00",
            description = "Beyoncé first rose to fame as a member of Destiny's Child in the 1990s. She went on to release a successful solo career, winning 28 Grammy Awards and selling over 200 million records worldwide. Her latest album, Renaissance, was released in July 2023.\n" +
                    "\n" +
                    "The Renaissance World Tour is a celebration of Beyoncé's return. The tour will feature a mix of her greatest hits and new music from Renaissance.\n" +
                    "\n" +
                    "Tickets are on sale now!",
            bannerResId = com.example.laboratorio5.R.drawable.beyoncebanner
        ),
        ConcertDetail(
            artist = "Coldplay",
            title = "Coldplay Barcelona",
            subTitle = "Camp Nou",
            date = "5/28",
            time = "20:00",
            description = "Coldplay is back in Barcelona with their Music of the Spheres World Tour!\n" +
                    "\n" +
                    "The Music of the Spheres World Tour is a celebration of Coldplay's return. The tour is designed to be sustainable and environmentally friendly, with the band offsetting their carbon emissions and using renewable energy sources.\n" +
                    "\n" +
                    "Tickets are on sale now!",
            bannerResId = com.example.laboratorio5.R.drawable.coldplaybanner
        ),
        ConcertDetail(
            artist = "Jonas Brothers",
            title = "Jonas Brothers NY",
            subTitle = "Madison Square Garden",
            date = "19:00",
            time = "9/29",
            description = "Jonas Brothers are back in New York City with their Remember This Tour!\n" +
                    "\n" +
                    "The pop-rock trio is set to perform at the Madison Square Garden on September 29, 2023. This is their first tour in over five years, and fans are excited to see them back on stage.\n" +
                    "\n" +
                    "The Remember This Tour is a celebration of Jonas Brothers' return. The tour will feature a mix of their greatest hits and new music from Remember This.\n" +
                    "\n" +
                    "Tickets are on sale now!",
            bannerResId = com.example.laboratorio5.R.drawable.jbanner
        ),
        ConcertDetail(
            artist = "WOS",
            title = "WOS Buenos Aires",
            subTitle = "Estadio Obras Sanitarias",
            date = "10/28",
            time = "19:00",
            description = "WOS is back in Buenos Aires with his \"Oscuro Éxtasis Tour\"!\n" +
                    "\n" +
                    "WOS first rose to fame in 2017 with his participation in the FMS Argentina competition. He has since released two studio albums, \"Oscuro Éxtasis\" (2021) and \"Canguro\" (2022), both of which were critical and commercial successes.\n" +
                    "\n" +
                    "The \"Oscuro Éxtasis Tour\" is a celebration of WOS's success. The tour will feature a mix of his greatest hits and new music from \"Oscuro Éxtasis\".\n" +
                    "\n" +
                    "Tickets are on sale now!",
            bannerResId = com.example.laboratorio5.R.drawable.bannerwos
        )
    )

    val concert =
        detailsConcerts.firstOrNull { it.artist == concertId } // Busca el concierto por el título

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = { Text(text = "TodoEventos") },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        painter = painterResource(com.example.laboratorio5.R.drawable.arrowback),
                        contentDescription = "Back"
                    )
                }
            },
            actions = {
            }
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
                concert?.let {
                    Image(
                        painter = painterResource(id = it.bannerResId),
                        contentDescription = "Banner Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(1.dp)
                            .padding(bottom = 1.dp),
                        contentScale = ContentScale.Crop

                    )
                }
            }

            concert?.let {
                Text(
                    text = it.title, //Título
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = it.subTitle,  //Subtítulo
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(1.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DetailItem(
                        icon = painterResource(id = com.example.laboratorio5.R.drawable.calendar),
                        text = "Fecha: ${it.date}"
                    )
                    DetailItem(
                        icon = painterResource(id = com.example.laboratorio5.R.drawable.access_time),
                        text = "Hora: ${it.time}"
                    )
                }

                Text(
                    text = "About",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(14.dp)
                )

                Text(
                    text = it.description, //Descripción
                    fontSize = 16.sp,
                    modifier = Modifier.padding(10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Justify // Esto justifica el texto
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .width(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF9EA9ED),
                            contentColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Text(text = "Favorite")
                    }
                    Button(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .width(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF9EA9ED),
                            contentColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Text(text = "Buy")
                    }
                }
            }
        }

    }
}


@Composable
fun DetailItem(icon: Painter, text: String) { //Para lo icons de date y time
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


