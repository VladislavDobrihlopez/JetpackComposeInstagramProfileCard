package com.voitov.jetpackcomposefixedinstagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.InstagramProfileCard
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.JetpackComposeFixedInstagramCardTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeFixedInstagramCardTheme {
                ProfilesFeed()
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ProfilesFeed() {
        val lazyList = rememberLazyListState()
        val scope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            val profiles = viewModel.userProfile.observeAsState(listOf())


            LazyColumn(
                state = lazyList,
            ) {
                items(profiles.value, key = { it.id }) { profile ->
                    val dismiss = rememberDismissState()

                    if (dismiss.isDismissed(DismissDirection.EndToStart)) {
                        viewModel.remove(profile)
                    }

                    SwipeToDismiss(
                        state = dismiss,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                                    .background(Color.Red)
                                    .padding(end = 16.dp),
                                contentAlignment = Alignment.CenterEnd,
                            ) {
                                Text(
                                    "DELETE",
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(profile) {
                            viewModel.changeFollowingStatus(it.id)
                        }
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            FloatingActionButton(
                modifier = Modifier.padding(24.dp),
                shape = RoundedCornerShape(24.dp),
                onClick = {
                    scope.launch {
                        lazyList.scrollToItem(0)
                    }
                }) {

            }
        }
    }
}