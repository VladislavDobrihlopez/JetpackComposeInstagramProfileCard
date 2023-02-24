package com.voitov.jetpackcomposefixedinstagramcard.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InstagramProfileCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
        )
        VerticalArrangementTextPair()
        VerticalArrangementTextPair()
        VerticalArrangementTextPair()
    }
}

@Composable
private fun VerticalArrangementTextPair() {
    Column(
        modifier = Modifier
            .width(50.dp)
            .height(80.dp)
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(Color.Green)
        )
    }
}