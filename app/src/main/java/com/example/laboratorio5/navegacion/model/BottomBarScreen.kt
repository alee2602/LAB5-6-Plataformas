package com.example.laboratorio5.navegacion.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class  BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector

){
    object Events: BottomBarScreen(
        route="events",
        title= "Events",
        icon= Icons.Default.Home
    )

    object Places: BottomBarScreen(
        route="places",
        title= "Places",
        icon= Icons.Default.LocationOn
    )

    object Profile: BottomBarScreen(
        route="profile",
        title= "Profile",
        icon= Icons.Default.Person
    )

    object Favorites: BottomBarScreen(
        route="favorites",
        title= "Favorites",
        icon= Icons.Default.Favorite
    )
}




