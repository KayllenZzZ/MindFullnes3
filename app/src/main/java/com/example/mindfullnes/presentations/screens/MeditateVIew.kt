package com.example.mindfullnes.presentations.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mindfullnes.FilterOptionsComponent
import com.example.mindfullnes.presentations.components.HeaderProfileComponent
import com.example.mindfullnes.presentations.navigation.Navigation
import com.example.mindfullnes.ui.theme.Grey

@OptIn(ExperimentalComposeApi::class)
@Composable
fun MeditateView() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .background(Grey)
            .fillMaxSize()
    ) {
        HeaderProfileComponent()
        FilterOptionsComponent(navController = navController)
        Navigation(navController)
    }
}