package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.data.AppData
import com.example.ui.components.AppTopBar

@Composable
fun ColorQuizHubScreen(onNavigateBack: () -> Unit, onSelectQuiz: (String) -> Unit) {
    val choices = AppData.lessons.map { it.id to it.colorName } + ("all" to "All Colors")
    Scaffold(
        topBar = { AppTopBar(title = "Color Quiz Hub", onBackClick = onNavigateBack) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Choose a color to practice",
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            choices.forEach { (id, name) ->
                val lessonColor = AppData.lessons.firstOrNull { it.id == id }?.hexColor
                    ?.let { runCatching { Color(android.graphics.Color.parseColor(it)) }.getOrNull() }
                    ?: MaterialTheme.colorScheme.primary
                val isWhiteLesson = AppData.lessons.firstOrNull { it.id == id }?.colorName == "White"
                val iconColor = if (isWhiteLesson && MaterialTheme.colorScheme.background.luminance() >= 0.5f) {
                    Color(0xFFD6D6CC)
                } else {
                    lessonColor
                }
                Card(
                    modifier = Modifier.weight(1f).fillMaxWidth().clickable { onSelectQuiz(id) }.testTag("quiz_hub_$id"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(if (id == "all") Icons.Filled.Quiz else Icons.Filled.Star, contentDescription = null, tint = iconColor, modifier = Modifier.padding(end = 16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(name, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                            Text(if (id == "all") "Play every question" else "Take the $name quiz", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Icon(Icons.Filled.ArrowForwardIos, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}
