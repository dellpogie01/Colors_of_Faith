package com.example

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.navigation.AppNavGraph
import com.example.storage.AppSettingsStore
import com.example.storage.ThemePreference
import com.example.ui.theme.ColorsOfFaithTheme
import java.util.*

class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener {
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        textToSpeech = TextToSpeech(this, this)
        val settingsStore = AppSettingsStore(applicationContext)

        setContent {
            val preference by settingsStore.themePreference.collectAsState(initial = ThemePreference.DARK)
            val systemDark = isSystemInDarkTheme()
            val useDarkTheme = when (preference) {
                ThemePreference.LIGHT -> false
                ThemePreference.DARK -> true
                ThemePreference.SYSTEM -> systemDark
            }
            ColorsOfFaithTheme(darkTheme = useDarkTheme) {
                AppNavGraph(
                    settingsStore = settingsStore,
                    onSpeak = { text ->
                        speakOut(text)
                    }
                )
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech?.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Graceful fallback if TTS language is not supported
            }
        }
    }

    private fun speakOut(text: String) {
        if (textToSpeech != null) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            Toast.makeText(this, "Text-to-speech not available", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }
        super.onDestroy()
    }
}
