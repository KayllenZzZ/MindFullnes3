package com.example.mindfullnes.presentations.navigation

sealed class NavItem(val route: String, var title: String) {
    object Meditate: NavItem("meditate", "Meditate")
    object Breathe: NavItem("breathe", "Breathe")
}