package com.example.mindfullnes.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mindfullnes.MeditateView

@ExperimentalComposeApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Meditate.route) {
        composable(NavItem.Meditate.route) {
         MeditateView()
        }
    }
}