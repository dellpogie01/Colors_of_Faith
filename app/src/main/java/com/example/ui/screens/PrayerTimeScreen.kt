package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.AppData
import com.example.storage.StorageManager
import com.example.ui.components.AppTopBar
import com.example.ui.components.AudioReadButton
import com.example.ui.theme.*

@Composable
fun PrayerTimeScreen(
    storageManager: StorageManager,
    onNavigateBack: () -> Unit,
    onOpenFavorites: () -> Unit,
    onSpeak: (String) -> Unit
) {
    val prayers = AppData.prayers

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Prayer Time",
                onBackClick = onNavigateBack,
                onFavoritesClick = onOpenFavorites
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SoftSkyBlue.copy(alpha = 0.5f).compositeOver(MaterialTheme.colorScheme.background)
                    )
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Talk to God Through Prayer",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = BlueColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Prayer is simply talking to God like a loving Father. You can share your joys, say thank you, and ask for His help anytime!",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }

            items(prayers) { prayer ->
                val prayerKey = "prayer_${prayer.id}"
                var isBookmarked by remember { mutableStateOf(storageManager.isBookmarked(prayerKey)) }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("prayer_card_${prayer.id}"),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = prayer.title,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = AccentPurple,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = {
                                    val newState = storageManager.toggleBookmark(prayerKey)
                                    isBookmarked = newState
                                }
                            ) {
                                Icon(
                                    imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                                    contentDescription = "Bookmark",
                                    tint = if (isBookmarked) AccentOrange else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "\"${prayer.prayerText}\"",
                            style = MaterialTheme.typography.bodyLarge,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        if (prayer.bibleReference != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Reference: ${prayer.bibleReference}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = BlueColor
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            AudioReadButton(
                                textToSpeak = "${prayer.title}. ${prayer.prayerText}",
                                onSpeak = onSpeak
                            )
                        }
                    }
                }
            }
        }
    }
}
