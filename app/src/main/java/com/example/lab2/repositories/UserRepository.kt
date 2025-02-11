package com.example.lab2.repositories

class UserRepository {
    suspend fun getUser(): User {
        // Mock Data
        return User(1, "John Doe", "john.doe@example.com")
    }

    suspend fun updateUser(user: User): User {
        // Mock updating user
        return user
    }
}

class ShiftRepository {
    suspend fun getWorkedShifts(): List<Shift> {
        // Mock Data
        return listOf(
            Shift(1, "2024-07-10", 8),
            Shift(2, "2024-07-09", 7)
        )
    }

    suspend fun getUpcomingShifts(): List<Shift> {
        // Mock Data
        return listOf(
            Shift(3, "2024-07-15", 8),
            Shift(4, "2024-07-16", 8)
        )
    }
}

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
