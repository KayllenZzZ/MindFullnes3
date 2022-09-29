package com.example.mindfullnes.utils

sealed class NavItem(val route: String, var title: String) {
    object Meditate: NavItem("meditate", "Meditate")
    object Breathe: NavItem("breathe", "Breathe")
}