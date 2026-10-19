package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.AppData
import com.example.storage.StorageManager
import com.example.ui.components.AppTopBar
import com.example.ui.theme.AccentOrange
import com.example.ui.theme.BlueColor
import com.example.ui.theme.GreenColor
import com.example.ui.theme.RedColor
import com.example.ui.theme.SoftSkyBlue

@Composable
fun ColorQuizScreen(
    colorId: String,
    storageManager: StorageManager,
    onNavigateBack: () -> Unit,
    onFinishQuiz: (String, Int, Int) -> Unit
) {
    val questions = remember(colorId) {
        if (colorId == "all") AppData.quizQuestions else AppData.quizQuestions.filter { it.colorId == colorId }
    }
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableIntStateOf(0) }
    val currentQuestion = questions.getOrNull(currentIndex)

    Scaffold(
        topBar = {
            AppTopBar(
                title = if (colorId == "all") "Color Quiz Hub" else "${colorId.replaceFirstChar { it.uppercase() }} Quiz",
                onBackClick = onNavigateBack
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (currentQuestion == null) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("No questions available.")
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Question ${currentIndex + 1} of ${questions.size}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    Surface(shape = RoundedCornerShape(12.dp), color = MaterialTheme.colorScheme.secondaryContainer) {
                        Text("Score: $score", modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSecondaryContainer)
                    }
                }
                LinearProgressIndicator(
                    progress = { (currentIndex + 1).toFloat() / questions.size.toFloat() },
                    modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                    color = AccentOrange,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Text(
                        currentQuestion.questionText,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                currentQuestion.options.forEachIndexed { index, option ->
                    val correct = index == currentQuestion.correctAnswerIndex
                    val selected = selectedOptionIndex == index
                    val answerColor = when {
                        selectedOptionIndex == null -> MaterialTheme.colorScheme.surface
                        correct -> GreenColor.copy(alpha = 0.20f)
                        selected -> RedColor.copy(alpha = 0.20f)
                        else -> MaterialTheme.colorScheme.surface
                    }
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable(enabled = selectedOptionIndex == null) {
                            selectedOptionIndex = index
                            if (correct) score += 1
                        }.testTag("quiz_option_$index"),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = answerColor)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(Modifier.size(30.dp).clip(CircleShape).background(if (selectedOptionIndex != null && correct) GreenColor else SoftSkyBlue), contentAlignment = Alignment.Center) {
                                Text(('A' + index).toString(), fontWeight = FontWeight.Bold, color = if (selectedOptionIndex != null && correct) Color.White else BlueColor)
                            }
                            Spacer(Modifier.width(12.dp))
                            Text(option, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }
                Box(modifier = Modifier.fillMaxWidth().height(128.dp)) {
                    if (selectedOptionIndex != null) {
                        val isCorrect = selectedOptionIndex == currentQuestion.correctAnswerIndex
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = if (isCorrect) GreenColor.copy(alpha = 0.15f) else AccentOrange.copy(alpha = 0.15f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                Text(
                                    if (isCorrect) "Great job! That's correct! 🎉" else "Keep learning! Let's try that one again!",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCorrect) GreenColor else AccentOrange
                                )
                                Text(currentQuestion.explanation, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }
                }
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = {
                        if (currentIndex < questions.size - 1) {
                            currentIndex += 1
                            selectedOptionIndex = null
                        } else {
                            if (colorId != "all") storageManager.setQuizScore(colorId, score)
                            onFinishQuiz(colorId, score, questions.size)
                        }
                    },
                    enabled = selectedOptionIndex != null,
                    modifier = Modifier.fillMaxWidth().height(52.dp).testTag("next_question_button"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AccentOrange)
                ) {
                    Text(if (currentIndex < questions.size - 1) "Next Question" else "View Results", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    }
}
