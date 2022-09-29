package com.example.mindfullnes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mindfullnes.presentations.navigation.NavItem
import com.example.mindfullnes.presentations.screens.MeditateView
import com.example.mindfullnes.ui.theme.*
import com.example.mindfullnes.utils.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindFullnesTheme {
                MeditateView()
            }
        }
    }
}

@Composable
fun FilterOptionsComponent(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val filterOptions = FILTER_CONTENT_LIST
    val items = listOf(NavItem.Meditate, NavItem.Breathe)
    Row(
        Modifier.padding(top = 16.dp, start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        //items(filterOptions.size) {
        //  ChipComponent(filter = filterOptions[it])
        items.forEach { item ->
            if (currentRoute != null) {
                ChipComponent(
                    filter = FilterContent(
                        backgroundColor = Black,
                        contentColor = Color.White,
                        filterText = item.title
                    ), currentRoute, item.route, navController
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipComponent(
    filter: FilterContent,
    currentRoute: String,
    route: String,
    navController: NavController,
) {
    val contentColor = filter.contentColor
    val chipBackground = filter.backgroundColor
    val filterText = filter.filterText
    val selected = currentRoute == route
    val animationProgress: Float by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(1000)
    )
    Chip(
        onClick = {
            navController.navigate(route) {
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = ChipDefaults.chipColors(
            contentColor = if (selected) contentColor else chipBackground,
            //backgroundColor = if (selected) chipBackground else contentColor
            backgroundColor = colorScheme.primary.copy(alpha = animationProgress)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = filterText, fontFamily = nunitoMedium)
    }
}

@Composable
fun MeditationTypesComponent(type: Int) {
    val meditationOptions = if (type == 2) MEDITATION_TYPE_LIST_2 else MEDITATION_TYPE_LIST
    LazyColumn(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(meditationOptions.size) {
            MeditationOptionComponent(meditationTypes = meditationOptions[it])
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MeditationOptionComponent(meditationTypes: MeditationType) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxSize(),
        backgroundColor = meditationTypes.backgroundColor
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = meditationTypes.timeBackgroundColor
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = meditationTypes.duration, fontFamily = nunitoMedium)
                }
                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = meditationTypes.teacher, fontFamily = nunitoMedium)
                }
            }

            Text(
                text = meditationTypes.title,
                fontFamily = nunitoBold,
                fontSize = 18.sp,
                color = meditationTypes.contentColor,
                textAlign = TextAlign.Start
            )

            Text(
                text = meditationTypes.description,
                fontFamily = nunitoLight,
                fontSize = 16.sp,
                color = meditationTypes.contentColor,
                textAlign = TextAlign.Start
            )
        }
    }
}