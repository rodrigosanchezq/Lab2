package com.example.lab2.repositories

import com.example.lab2.AppSettings


class AppSettingsRepository {
    private var settings = AppSettings(isDarkModeEnabled = false)

    fun toggleDarkMode(): AppSettings {
        settings = settings.copy(isDarkModeEnabled = !settings.isDarkModeEnabled)
        return settings
    }

    fun getAppSettings(): AppSettings {
        return settings
    }
}