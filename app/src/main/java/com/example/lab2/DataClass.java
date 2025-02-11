package com.example.lab2;



data class User(val id: Int, val name: String, val email: String)

data class Shift(val id: Int, val date: String, val hoursWorked: Int)

data class AppSettings(val isDarkModeEnabled: Boolean)
