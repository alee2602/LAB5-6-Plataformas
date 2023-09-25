package com.example.laboratorio5.navegacion.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.laboratorio5.ui.concerts.view.ConcertMainApp
import com.example.laboratorio5.ui.detail.view.PlacesMainApp
import com.example.laboratorio5.ui.favorites.view.FavoritesMainApp
import com.example.laboratorio5.ui.profile.view.ProfileMainApp

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Events.route
    ){
        composable(route=BottomBarScreen.Events.route){
            ConcertMainApp(navController)
        }
        composable(route=BottomBarScreen.Places.route){
            PlacesMainApp()
        }
        composable(route=BottomBarScreen.Profile.route){
            ProfileMainApp()
        }
        composable(route=BottomBarScreen.Favorites.route){
            FavoritesMainApp()
        }
    }
}