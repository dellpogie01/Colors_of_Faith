package com.example.storage

import android.content.Context
import android.content.SharedPreferences

class StorageManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("colors_of_faith_prefs", Context.MODE_PRIVATE)

    fun isLessonCompleted(lessonId: String): Boolean {
        return prefs.getBoolean("lesson_completed_$lessonId", false)
    }

    fun setLessonCompleted(lessonId: String, completed: Boolean) {
        prefs.edit().putBoolean("lesson_completed_$lessonId", completed).apply()
    }

    fun getQuizScore(lessonId: String): Int {
        return prefs.getInt("quiz_score_$lessonId", 0)
    }

    fun setQuizScore(lessonId: String, score: Int) {
        val currentBest = getQuizScore(lessonId)
        if (score > currentBest) {
            prefs.edit().putInt("quiz_score_$lessonId", score).apply()
        }
    }

    fun isBookmarked(id: String): Boolean {
        return prefs.getBoolean("bookmark_$id", false)
    }

    fun toggleBookmark(id: String): Boolean {
        val current = isBookmarked(id)
        val newState = !current
        prefs.edit().putBoolean("bookmark_$id", newState).apply()
        return newState
    }

    fun getAllBookmarks(): Set<String> {
        val allEntries = prefs.all
        return allEntries.filter { it.key.startsWith("bookmark_") && it.value == true }
            .map { it.key.removePrefix("bookmark_") }
            .toSet()
    }

    fun getTotalStars(): Int {
        // Count completed lessons (1 star each) + quiz best scores
        var stars = 0
        val lessonIds = listOf("gold", "black", "red", "white", "green", "blue")
        for (id in lessonIds) {
            if (isLessonCompleted(id)) stars += 1
            stars += getQuizScore(id)
        }
        return stars
    }
}
