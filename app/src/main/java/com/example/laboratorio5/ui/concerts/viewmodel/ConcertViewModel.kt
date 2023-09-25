package com.example.laboratorio5.ui.concerts.viewmodel

import androidx.lifecycle.ViewModel
import com.example.laboratorio5.R
import com.example.laboratorio5.ui.concerts.view.Concert

class ConcertViewModel: ViewModel(){
    val concerts: List<Concert> = listOf(
        Concert(imageId = R.drawable.beyonce, title = "Beyoncé", supportingText = "Reinassance Tour"),
        Concert(imageId = R.drawable.bigtimerush, title = "Big Time Rush", supportingText = "Can´t Get Enough Tour"),
        Concert(imageId = R.drawable.coldplay, title = "Coldplay", supportingText = "Music of The Spheres World Tour"),
        Concert(imageId = R.drawable.jonas_brothers, title = "Jonas Brothers", supportingText = "Five Albums. One Night. The Tour"),
        Concert(imageId = R.drawable.taylor_swift, title = "Taylor Swift", supportingText = "The Eras Tour"),
        Concert(imageId= R.drawable.the_weekend, title = "The Weekend", supportingText = "After Hours Til Dawn Stadium Tour"),
    )
}




