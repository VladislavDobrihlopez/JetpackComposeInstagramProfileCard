package com.voitov.jetpackcomposefixedinstagramcard.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voitov.jetpackcomposefixedinstagramcard.R

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
            Image(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .size(75.dp)
                    .clip(shape = CircleShape)
                    .background(MaterialTheme.colors.onBackground),
                painter = painterResource(id = R.drawable.ic_instagram_logo),
                contentDescription = "profile image",
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.background)
            )
            UserAccountStats("3760", stringResource(R.string.posts))
            UserAccountStats("17M", stringResource(R.string.followers))
            UserAccountStats("200", stringResource(R.string.following))
        }
    }
}

@Composable
private fun UserAccountStats(value: String, param: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = value,
            color = MaterialTheme.colors.onBackground,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive,
        )
        Text(
            text = param,
            color = MaterialTheme.colors.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
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