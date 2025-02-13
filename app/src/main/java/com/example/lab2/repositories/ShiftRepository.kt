package com.example.lab2.repositories

import com.example.lab2.Shift

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