package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.storage.AppSettingsStore
import com.example.storage.ThemePreference
import com.example.ui.components.AppTopBar
import kotlinx.coroutines.launch

@Composable
fun AboutPrivacyScreen(
    onNavigateBack: () -> Unit,
    settingsStore: AppSettingsStore
) {
    val preference by settingsStore.themePreference.collectAsState(initial = ThemePreference.DARK)
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { AppTopBar(title = "Settings", onBackClick = onNavigateBack) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("About", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Colors of Faith — Bible for Kids",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Designed to teach children the Christian message of salvation through the traditional Colors of Salvation / Wordless Book concept. Children can explore interactive color lessons, read accurate KJV Bible verses, take quizzes, track their learning journey, and pray.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Text("Preferences", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    ThemePreference.entries.forEach { option ->
                        val label = when (option) {
                            ThemePreference.LIGHT -> "Light"
                            ThemePreference.DARK -> "Dark"
                            ThemePreference.SYSTEM -> "System default"
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { scope.launch { settingsStore.setThemePreference(option) } }
                                .padding(horizontal = 16.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = label,
                                modifier = Modifier.weight(1f),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            RadioButton(
                                selected = preference == option,
                                onClick = { scope.launch { settingsStore.setThemePreference(option) } }
                            )
                        }
                    }
                }
            }
        }
    }
}
