package com.example.ui.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.theme.*
import com.example.R
import androidx.core.view.WindowCompat

@Composable
fun SplashScreen(onNavigateHome: () -> Unit) {
    var isLeavingSplash by remember { mutableStateOf(false) }
    val view = LocalView.current
    val window = (view.context as? Activity)?.window
    val proceedToHome = {
        if (!isLeavingSplash) {
            isLeavingSplash = true
            onNavigateHome()
        }
    }
    SideEffect {
        window?.let { WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = true }
    }
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000L)
        proceedToHome()
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .clickable(onClick = { proceedToHome() })
            .testTag("splash_screen"),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = maxHeight)
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(420.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.splash_logo),
                    contentDescription = "Colors of Faith logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(324.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Colors of Faith",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Discover God's Love Through His Word",
                style = MaterialTheme.typography.titleLarge,
                color = AccentPurple,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Surface(
                color = Color(0xFFF5F5F0),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(Gold, DarkCharcoal, RedColor, Color.White, GreenColor, BlueColor).forEach { color ->
                        Box(
                            modifier = Modifier
                                .size(width = 24.dp, height = 12.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(color)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Tap anywhere to begin",
                style = MaterialTheme.typography.bodyMedium,
                color = DarkCharcoal
            )
        }
    }
}
