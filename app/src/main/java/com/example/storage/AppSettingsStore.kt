package com.example.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.settingsDataStore by preferencesDataStore(name = "app_settings")

enum class ThemePreference {
    LIGHT, DARK, SYSTEM
}

class AppSettingsStore(context: Context) {
    private val dataStore = context.applicationContext.settingsDataStore
    private val themeKey = stringPreferencesKey("theme_preference")

    val themePreference: Flow<ThemePreference> = dataStore.data.map { preferences ->
        preferences[themeKey]?.let { value ->
            runCatching { ThemePreference.valueOf(value) }.getOrNull()
        } ?: ThemePreference.DARK
    }

    suspend fun setThemePreference(preference: ThemePreference) {
        dataStore.edit { preferences -> preferences[themeKey] = preference.name }
    }
}
