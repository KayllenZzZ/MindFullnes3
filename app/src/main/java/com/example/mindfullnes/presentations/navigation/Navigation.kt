package com.example.mindfullnes.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mindfullnes.MeditationTypesComponent

@ExperimentalComposeApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Meditate.route) {
        composable(NavItem.Meditate.route) {
            MeditationTypesComponent(1)
        }
        composable(NavItem.Breathe.route) {
            MeditationTypesComponent(2)
        }
    }
}