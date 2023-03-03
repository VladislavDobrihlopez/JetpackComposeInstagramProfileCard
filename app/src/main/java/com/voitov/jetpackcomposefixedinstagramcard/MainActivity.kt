package com.voitov.jetpackcomposefixedinstagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.InstagramProfileCard
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.JetpackComposeFixedInstagramCardTheme

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

    @Composable
    fun ProfilesFeed() {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {

            val profiles = viewModel.userProfile.observeAsState(listOf())

            LazyColumn {
                for (profile in profiles.value) {
                    item {
                        InstagramProfileCard(profile) {
                            viewModel.changeFollowingStatus(it.id)
                        }
                    }
                }
            }
        }
    }
}