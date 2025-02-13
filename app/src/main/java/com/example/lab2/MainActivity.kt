package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.repositories.AppSettingsRepository
import com.example.lab2.repositories.ShiftRepository
import com.example.lab2.repositories.UserRepository
import com.example.lab2.ui.MainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userViewModel: UserViewModel = viewModel { UserViewModel(UserRepository()) }
            val shiftViewModel: ShiftViewModel = viewModel { ShiftViewModel(ShiftRepository()) }
            val appSettingsViewModel: AppSettingsViewModel = viewModel {
                AppSettingsViewModel(AppSettingsRepository())
            }

            MainApp(
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                appSettingsViewModel = appSettingsViewModel
            )
        }
    }
}
