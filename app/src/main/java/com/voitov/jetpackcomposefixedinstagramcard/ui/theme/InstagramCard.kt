package com.voitov.jetpackcomposefixedinstagramcard.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InstagramProfileCard() {
    Card(
        modifier = Modifier.padding(all = 8.dp),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
    ) {
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

@Preview
@Composable
fun InstagramProfileCardLightTheme() {
    JetpackComposeFixedInstagramCardTheme(darkTheme = false) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun InstagramProfileCardDarkTheme() {
    JetpackComposeFixedInstagramCardTheme(darkTheme = true) {
        InstagramProfileCard()
    }
}