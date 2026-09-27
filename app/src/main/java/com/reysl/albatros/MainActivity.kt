package com.reysl.albatros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.reysl.designsystem.haptics.AlbatrosHapticFeedback
import com.reysl.designsystem.haptics.AndroidHapticFeedback
import com.reysl.designsystem.theme.theme.AlbatrosTheme
import com.reysl.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val hapticFeedback: AlbatrosHapticFeedback = AndroidHapticFeedback(this)

        setContent {
            AlbatrosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        hapticFeedback = hapticFeedback,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}