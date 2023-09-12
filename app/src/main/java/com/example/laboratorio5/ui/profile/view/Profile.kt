
package com.example.laboratorio5.ui.profile.view

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio5.R

data class UserProfile(val name: String) //Data class que contiene el nombre del usuario

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileMainApp()
        }
    }
}

@Composable
fun ProfileMainApp() {
    val user = UserProfile(name = "Ale")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .background(Color(android.graphics.Color.parseColor("#A9629F")))
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            // Ícono circular de foto de perfil
            CircleAvatar(
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp),
                imageId = R.drawable.ale_rockstar,
                contentDescription = "Profile Image"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            // Nombre del usuario centrado
            Text(
                text = user.name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
        }

        // Cards para cada opción dentro de la pantalla del perfil
        ProfileCard(icon = Icons.Default.Edit, text = "Edit Profile")
        ProfileCard(icon = Icons.Default.Lock, text = "Reset Password")
        ProfileCard(icon = Icons.Default.Notifications, text = "Notifications")
        ProfileCard(icon = Icons.Default.Favorite, text = "Favorites")
    }
}

@Composable
fun CircleAvatar(modifier: Modifier = Modifier, imageId:Int, contentDescription:String) { //Estructura para la foto de perfil
    Image(
        painter= painterResource(id = imageId),
        contentDescription= contentDescription,
        modifier = modifier
            .size(150.dp)
            .padding(16.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
    )

}

@Composable
fun ProfileCard(icon: ImageVector, text: String) { //Cards para cada una de las opciones dentro del perfil
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = LocalContentColor.current.copy(alpha = 0.6f),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text)
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = LocalContentColor.current.copy(alpha = 0.6f),
            modifier = Modifier.size(24.dp)
        )

    }
}