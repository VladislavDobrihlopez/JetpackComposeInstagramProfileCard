package com.voitov.jetpackcomposefixedinstagramcard.ui.theme

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.voitov.jetpackcomposefixedinstagramcard.InstaProfile
import com.voitov.jetpackcomposefixedinstagramcard.R

private const val TAG = "recomposition_tag"

@Composable
fun InstagramProfileCard(
    profile: InstaProfile,
    onFollowButtonClickListener: (InstaProfile) -> Unit
) {
    Card(
        modifier = Modifier.padding(all = 8.dp),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
    ) {
        Log.d(TAG, "Card")
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
                    painter = painterResource(id = profile.avatarResId),
                    contentDescription = profile.description,
                    contentScale = ContentScale.FillHeight,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.background)
                )
                UserAccountStats(profile.posts.toString(), stringResource(R.string.posts))
                UserAccountStats(profile.followers.toString(), stringResource(R.string.followers))
                UserAccountStats(profile.following.toString(), stringResource(R.string.following))
            }
            Column(modifier = Modifier.padding(all = 8.dp)) {
                UserAccountDescription()
                PossibleActions(profile) {
                    onFollowButtonClickListener(profile)
                }
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
private fun PossibleActions(userProfile: InstaProfile, onFollowButtonClickListener: () -> Unit) {
    Log.d(TAG, "PossibleActions")
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        FollowButton(userProfile) {
            onFollowButtonClickListener()
        }
        MessageButton()
    }
}

@Composable
private fun RowScope.FollowButton(
    userProfile: InstaProfile,
    callback: (() -> Unit)?
) {
    Log.d(TAG, "Follow button")
    Button(
        onClick = {
            callback?.invoke()
        },
        modifier = Modifier
            .weight(1f)
            .padding(end = 2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (userProfile.isFollower) {
                Color.Red.copy(0.5f)
            } else {
                MaterialTheme.colors.background
            },
            contentColor = MaterialTheme.colors.onBackground
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        val buttonText = if (userProfile.isFollower) {
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
        //InstagramProfileCard(MainViewModel())
    }
}

@Preview
@Composable
fun InstagramProfileCardDarkTheme() {
    JetpackComposeFixedInstagramCardTheme(darkTheme = true) {
        //InstagramProfileCard(MainViewModel())
    }
}