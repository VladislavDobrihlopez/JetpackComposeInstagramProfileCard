package com.voitov.jetpackcomposefixedinstagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
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
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxSize()
                ) {
                    InstagramProfileCard(viewModel)
                }
            }
        }
    }
}