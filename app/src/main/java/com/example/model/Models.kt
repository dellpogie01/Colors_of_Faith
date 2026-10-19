package com.example.model

data class ColorLesson(
    val id: String,
    val colorName: String,
    val hexColor: String,
    val title: String,
    val meaning: String,
    val explanation: String,
    val verses: List<BibleVerseItem>,
    val practicalApplication: String,
    val prayer: String,
    val rememberThis: String,
    val iconResName: String
)

data class BibleVerseItem(
    val reference: String,
    val text: String,
    val colorId: String
)

data class QuizQuestion(
    val id: Int,
    val colorId: String,
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)

data class PrayerItem(
    val id: String,
    val title: String,
    val prayerText: String,
    val bibleReference: String?
)

data class ParentGuideSection(
    val title: String,
    val content: String,
    val discussionQuestions: List<String>
)
