package com.example.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.AndroidViewConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = BlueColor,
    onPrimary = WhiteColor,
    secondary = AccentOrange,
    onSecondary = WhiteColor,
    tertiary = AccentPurple,
    background = BackgroundCream,
    onBackground = MainText,
    surface = CardBackground,
    onSurface = MainText,
    surfaceVariant = SurfaceVariantColor
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF82B6FF),
    onPrimary = Color.White,
    secondary = Color(0xFFFFB968),
    onSecondary = Color(0xFF402200),
    tertiary = Color(0xFFC6B5FF),
    background = Color(0xFF17191D),
    onBackground = Color(0xFFF0F0F3),
    surface = Color(0xFF24272D),
    onSurface = Color(0xFFF0F0F3),
    surfaceVariant = Color(0xFF393C43),
    onSurfaceVariant = Color(0xFFD0D2D8)
)

@Composable
fun ColorsOfFaithTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            window.navigationBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).apply {
                isAppearanceLightStatusBars = !darkTheme
                isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
