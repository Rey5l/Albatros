package com.reysl.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.reysl.designsystem.haptics.AlbatrosHapticFeedback
import com.reysl.designsystem.haptics.HapticType

@Composable
fun HomeScreen(
    innerPadding: PaddingValues = PaddingValues(16.dp, 24.dp),
    hapticFeedback: AlbatrosHapticFeedback
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Button(
            onClick = {
                hapticFeedback.perform(HapticType.Tap)
            }
        ) {
            Text("Tap me")
        }
    }
}