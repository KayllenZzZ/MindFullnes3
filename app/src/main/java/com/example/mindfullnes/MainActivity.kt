package com.example.mindfullnes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
        Navigation(navController)
        MeditationTypesComponent()
    }
}

@Preview
@Composable
fun HeaderProfileComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.i),
                contentDescription = "Profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = "Welcome back",
                    fontFamily = nunitoLight,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Miranda Smith",
                    fontFamily = nunitoBold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start
                )
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
fun ChipComponent(filter: FilterContent, currentRoute: String, route: String, navController: NavController) {
    val contentColor = filter.contentColor
    val chipBackground = filter.backgroundColor
    val filterText = filter.filterText
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
            contentColor = contentColor,
            backgroundColor = chipBackground
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = filterText, fontFamily = nunitoMedium)
    }
}

@Composable
fun MeditationTypesComponent() {
    val meditationOptions = MEDITATION_TYPE_LIST
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