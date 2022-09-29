package com.example.mindfullnes.utils

import androidx.compose.ui.graphics.Color
import com.example.mindfullnes.ui.theme.Black
import com.example.mindfullnes.ui.theme.Green
import com.example.mindfullnes.ui.theme.Yellow

val FILTER_CONTENT_LIST = listOf(
    FilterContent(Color.White, Black, "Meditate"),
    FilterContent(Black, Color.White, "Breathe")
)

val MEDITATION_TYPE_LIST = listOf(
    MeditationType(
        "45 mins",
        "James Madchen",
        "Love-kind meditation",
        "During loving kindness meditation, you focus benevolent and loving energy toward yourself and others.",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "34 mins",
        "Kate Landon",
        "Flower meditation",
        "Outdoor concentration meditation, the object is a flower.",
        Green,
        Black,
        Yellow
    )
)

val MEDITATION_TYPE_LIST_2 = listOf(
    MeditationType(
        "45 mins",
        "James Madchen",
        "Love-kind meditation",
        "During loving kindness meditation, you focus benevolent and loving energy toward yourself and others.",
        Green,
        Black,
        Yellow
    ),
    MeditationType(
        "34 mins",
        "Kate Landon",
        "Flower meditation",
        "Outdoor concentration meditation, the object is a flower.",
        Yellow,
        Black,
        Green
    )
)