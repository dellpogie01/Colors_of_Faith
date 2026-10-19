package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AppData
import com.example.storage.StorageManager
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

@Composable
fun FavoritesScreen(
    storageManager: StorageManager,
    onNavigateBack: () -> Unit,
    onSelectLesson: (String) -> Unit
) {
    var bookmarks by remember { mutableStateOf(storageManager.getAllBookmarks()) }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "My Favorites",
                onBackClick = onNavigateBack
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (bookmarks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Outlined.Inbox,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "No bookmarks yet!",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Tap the bookmark icon on lessons, verses, or prayers to save them here.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(bookmarks.toList()) { bookmarkId ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                val title = when {
                                    bookmarkId.startsWith("lesson_") -> {
                                        val colorId = bookmarkId.removePrefix("lesson_")
                                        val lesson = AppData.lessons.find { it.id == colorId }
                                        "Lesson: ${lesson?.colorName ?: colorId} - ${lesson?.title}"
                                    }
                                    bookmarkId.startsWith("verse_") -> {
                                        "Verse: ${bookmarkId.removePrefix("verse_")}"
                                    }
                                    bookmarkId.startsWith("prayer_") -> {
                                        val prayerId = bookmarkId.removePrefix("prayer_")
                                        val prayer = AppData.prayers.find { it.id == prayerId }
                                        "Prayer: ${prayer?.title ?: prayerId}"
                                    }
                                    else -> bookmarkId
                                }

                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                            IconButton(
                                onClick = {
                                    storageManager.toggleBookmark(bookmarkId)
                                    bookmarks = storageManager.getAllBookmarks()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Bookmark,
                                    contentDescription = "Remove Bookmark",
                                    tint = AccentOrange
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
