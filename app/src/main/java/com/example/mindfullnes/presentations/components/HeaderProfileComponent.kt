package com.example.mindfullnes.presentations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindfullnes.R
import com.example.mindfullnes.ui.theme.nunitoBold
import com.example.mindfullnes.ui.theme.nunitoLight

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