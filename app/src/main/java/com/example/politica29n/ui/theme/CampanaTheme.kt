package com.example.politica29n.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CampanaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF243754), onPrimary = Color.White,
            primaryContainer = Color(0xFFE1E8F2),
            secondary = Color(0xFF795B19),
            background = Color(0xFFF8F6F0), surface = Color(0xFFF8F6F0),
            onSurface = Color(0xFF202B3A)
        ),
        typography = Typography, content = content
    )
}
