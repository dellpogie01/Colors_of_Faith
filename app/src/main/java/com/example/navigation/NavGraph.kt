package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.storage.StorageManager
import com.example.storage.AppSettingsStore
import com.example.ui.screens.*

@Composable
fun AppNavGraph(
    settingsStore: AppSettingsStore,
    onSpeak: (String) -> Unit
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val usePrimaryNavigationBackground = currentRoute in setOf("colors", "verses", "journey", "prayers", "parents")
    val storageManager = StorageManager(context)

    Box(Modifier.fillMaxSize()) {
      NavHost(
          navController = navController,
          startDestination = "splash"
      ) {
        composable("splash") {
            SplashScreen(
                onNavigateHome = {
                    navController.navigate("home") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }
        composable("colors") {
            ColorLessonsScreen(
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onSelectLesson = { lessonId ->
                    navController.navigate("lesson_detail/$lessonId")
                },
                onOpenFavorites = {
                    navController.navigate("favorites")
                }
            )
        }
        composable(
            route = "lesson_detail/{lessonId}",
            arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
        ) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: "gold"
            ColorLessonDetailScreen(
                lessonId = lessonId,
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onStartQuiz = { colorId ->
                    navController.navigate("quiz/$colorId")
                },
                onSpeak = onSpeak
            )
        }
        composable("verses") {
            BibleVersesScreen(
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onOpenFavorites = {
                    navController.navigate("favorites")
                },
                onSpeak = onSpeak
            )
        }
        composable("quiz_hub") {
            ColorQuizHubScreen(
                onNavigateBack = { navController.popBackStack() },
                onSelectQuiz = { colorId -> navController.navigate("quiz/$colorId") }
            )
        }
        composable(
            route = "quiz/{colorId}",
            arguments = listOf(navArgument("colorId") { type = NavType.StringType })
        ) { backStackEntry ->
            val colorId = backStackEntry.arguments?.getString("colorId") ?: "gold"
            ColorQuizScreen(
                colorId = colorId,
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onFinishQuiz = { cid, score, total ->
                    navController.navigate("quiz_result/$cid/$score/$total") {
                        popUpTo("lesson_detail/$cid")
                    }
                }
            )
        }
        composable(
            route = "quiz_result/{colorId}/{score}/{total}",
            arguments = listOf(
                navArgument("colorId") { type = NavType.StringType },
                navArgument("score") { type = NavType.IntType },
                navArgument("total") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val colorId = backStackEntry.arguments?.getString("colorId") ?: "gold"
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            val total = backStackEntry.arguments?.getInt("total") ?: 5
            QuizResultScreen(
                colorId = colorId,
                score = score,
                total = total,
                onNavigateHome = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onRetryQuiz = {
                    if (colorId == "all") {
                        navController.navigate("quiz_hub") { popUpTo("quiz_hub") { inclusive = true } }
                    } else {
                        navController.navigate("quiz/$colorId") { popUpTo("quiz/$colorId") { inclusive = true } }
                    }
                }
            )
        }
        composable("journey") {
            LearningJourneyScreen(
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("prayers") {
            PrayerTimeScreen(
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onOpenFavorites = {
                    navController.navigate("favorites")
                },
                onSpeak = onSpeak
            )
        }
        composable("parents") {
            ParentsTeachersScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("favorites") {
            FavoritesScreen(
                storageManager = storageManager,
                onNavigateBack = { navController.popBackStack() },
                onSelectLesson = { lessonId ->
                    navController.navigate("lesson_detail/$lessonId")
                }
            )
        }
        composable("about") {
            AboutPrivacyScreen(
                onNavigateBack = { navController.popBackStack() },
                settingsStore = settingsStore
            )
        }
        composable("settings") {
            AboutPrivacyScreen(
                onNavigateBack = { navController.popBackStack() },
                settingsStore = settingsStore
            )
        }
      }
      if (usePrimaryNavigationBackground) {
          Box(
              modifier = Modifier
                  .align(Alignment.BottomCenter)
                  .fillMaxWidth()
                  .windowInsetsBottomHeight(WindowInsets.safeDrawing)
                  .background(MaterialTheme.colorScheme.primary)
          )
      }
    }
}
