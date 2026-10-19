package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.data.AppData
import com.example.storage.StorageManager
import com.example.ui.components.AppTopBar
import com.example.ui.components.LessonCard

@Composable
fun ColorLessonsScreen(
    storageManager: StorageManager,
    onNavigateBack: () -> Unit,
    onSelectLesson: (String) -> Unit,
    onOpenFavorites: () -> Unit
) {
    val lessons = AppData.lessons
    val bookmarkStates = remember(storageManager) {
        mutableStateMapOf<String, Boolean>().apply {
            lessons.forEach { lesson ->
                put(lesson.id, storageManager.isBookmarked("lesson_${lesson.id}"))
            }
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Learn the Colors",
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
            items(lessons) { lesson ->
                val isCompleted = storageManager.isLessonCompleted(lesson.id)
                val bestScore = storageManager.getQuizScore(lesson.id)
                val isBookmarked = bookmarkStates[lesson.id] ?: false

                LessonCard(
                    lesson = lesson,
                    isCompleted = isCompleted,
                    bestScore = bestScore,
                    isBookmarked = isBookmarked,
                    onClick = { onSelectLesson(lesson.id) },
                    onBookmarkClick = {
                        bookmarkStates[lesson.id] = storageManager.toggleBookmark("lesson_${lesson.id}")
                    }
                )
            }
        }
    }
}
