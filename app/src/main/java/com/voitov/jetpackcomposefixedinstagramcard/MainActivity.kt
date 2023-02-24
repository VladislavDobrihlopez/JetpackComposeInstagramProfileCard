package com.voitov.jetpackcomposefixedinstagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.InstagramProfileCard
import com.voitov.jetpackcomposefixedinstagramcard.ui.theme.JetpackComposeFixedInstagramCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeFixedInstagramCardTheme {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxSize()
                ) {
                    InstagramProfileCard()
                }
            }
        }
    }
}