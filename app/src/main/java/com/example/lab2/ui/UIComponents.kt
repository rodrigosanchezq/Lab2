package com.example.lab2.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.lab2.AppSettings
import com.example.lab2.AppSettingsViewModel
import com.example.lab2.Shift
import com.example.lab2.ShiftViewModel
import com.example.lab2.User
import com.example.lab2.UserViewModel

@Composable
fun MainApp(
    userViewModel: UserViewModel,
    shiftViewModel: ShiftViewModel,
    appSettingsViewModel: AppSettingsViewModel
) {
    val appSettings by appSettingsViewModel.appSettings.observeAsState(AppSettings(false))
    val isDarkTheme = appSettings.isDarkModeEnabled

    val user by userViewModel.user.observeAsState()
    val workedShifts by shiftViewModel.workedShifts.observeAsState(emptyList())
    val upcomingShifts by shiftViewModel.upcomingShifts.observeAsState(emptyList())

    MaterialTheme(
        colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ThemeToggleButton(appSettingsViewModel = appSettingsViewModel)

                user?.let {
                    UserInfo(user = it)
                }

                ShiftList(workedShifts = workedShifts, upcomingShifts = upcomingShifts)
            }
        }
    }
}

@Composable
fun ThemeToggleButton(appSettingsViewModel: AppSettingsViewModel) {
    val appSettings by appSettingsViewModel.appSettings.observeAsState(AppSettings(false))

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("Dark Mode: ")
        Switch(
            checked = appSettings.isDarkModeEnabled,
            onCheckedChange = { appSettingsViewModel.toggleDarkMode() }
        )
    }
}

@Composable
fun UserInfo(user: User) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "User Information", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${user.name}")
            Text(text = "Email: ${user.email}")
        }
    }
}

@Composable
fun ShiftList(workedShifts: List<Shift>, upcomingShifts: List<Shift>) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Worked Shifts", style = MaterialTheme.typography.headlineSmall)
            if (workedShifts.isEmpty()) {
                Text("No worked shifts.")
            } else {
                LazyColumn {
                    items(workedShifts) { shift ->
                        Text(text = "${shift.date}: ${shift.hoursWorked} hours")
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Upcoming Shifts", style = MaterialTheme.typography.headlineSmall)
            if (upcomingShifts.isEmpty()) {
                Text("No upcoming shifts.")
            } else {
                LazyColumn {
                    items(upcomingShifts) { shift ->
                        Text(text = "${shift.date}: ${shift.hoursWorked} hours")
                    }
                }
            }
        }
    }
}

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC5)
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5)
)
