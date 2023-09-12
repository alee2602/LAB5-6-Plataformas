
package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.laboratorio5.navegacion.model.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  //Aquí se hace el test de cada una de las pantallas
            //ConcertMainApp()
            //PlacesMainApp()
            //DetailsMainApp()
            //ProfileMainApp()
            //FavoritesMainApp()
            MainScreen()
        }
    }
}
