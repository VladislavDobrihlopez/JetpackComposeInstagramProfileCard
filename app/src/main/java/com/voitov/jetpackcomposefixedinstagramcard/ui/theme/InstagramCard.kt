package com.voitov.jetpackcomposefixedinstagramcard.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voitov.jetpackcomposefixedinstagramcard.MainViewModel
import com.voitov.jetpackcomposefixedinstagramcard.R

@Composable
fun InstagramProfileCard(viewModel: MainViewModel) {
    val isUserFollowed = viewModel.isFollowed.observeAsState(false)

    Card(
        modifier = Modifier.padding(all = 8.dp),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
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
            Column(modifier = Modifier.padding(all = 8.dp)) {
                UserAccountDescription()
                PossibleActions(viewModel, isUserFollowed)
            }
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

@Composable
private fun UserAccountDescription() {
    Text(
        "first_name last_name",
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.onBackground,
        fontSize = 16.sp,
    )
    Text(
        "some_description",
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.onBackground,
        fontSize = 16.sp,
    )
}

@Composable
private fun PossibleActions(viewModel: MainViewModel, state: State<Boolean>) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        FollowButton(state.value) {
            viewModel.changeFollowingStatus()
        }
        MessageButton()
    }
}

@Composable
private fun RowScope.FollowButton(
    isUserFollowed: Boolean,
    callback: (() -> Unit)?
) {
    Button(
        onClick = {
            callback?.invoke()
        },
        modifier = Modifier
            .weight(1f)
            .padding(end = 2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isUserFollowed) {
                Color.Red.copy(0.5f)
            } else {
                MaterialTheme.colors.background
            },
            contentColor = MaterialTheme.colors.onBackground
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        val buttonText = if (isUserFollowed) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(buttonText)
    }
}

@Composable
private fun RowScope.MessageButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .weight(1f)
            .padding(start = 2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground
        ),
        border = BorderStroke(
            1.dp, MaterialTheme.colors.onBackground
        )
    ) {
        Text("Message")
    }
}

@Preview
@Composable
fun InstagramProfileCardLightTheme() {
    JetpackComposeFixedInstagramCardTheme(darkTheme = false) {
        InstagramProfileCard(MainViewModel())
    }
}

@Preview
@Composable
fun InstagramProfileCardDarkTheme() {
    JetpackComposeFixedInstagramCardTheme(darkTheme = true) {
        InstagramProfileCard(MainViewModel())
    }
}