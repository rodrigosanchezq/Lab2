package com.example.lab2.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        loadUser()
    }

    fun loadUser() {
        viewModelScope.launch {
            _user.value = userRepository.getUser()
        }
    }

    fun updateUser(updatedUser: User) {
        viewModelScope.launch {
            _user.value = userRepository.updateUser(updatedUser)
        }
    }
}

class ShiftViewModel(private val shiftRepository: ShiftRepository) : ViewModel() {
    private val _workedShifts = MutableLiveData<List<Shift>>()
    val workedShifts: LiveData<List<Shift>> = _workedShifts

    private val _upcomingShifts = MutableLiveData<List<Shift>>()
    val upcomingShifts: LiveData<List<Shift>> = _upcomingShifts

    init {
        loadShifts()
    }

    fun loadShifts() {
        viewModelScope.launch {
            _workedShifts.value = shiftRepository.getWorkedShifts()
            _upcomingShifts.value = shiftRepository.getUpcomingShifts()
        }
    }
}

class AppSettingsViewModel(private val appSettingsRepository: AppSettingsRepository) : ViewModel() {
    private val _appSettings = MutableLiveData<AppSettings>()
    val appSettings: LiveData<AppSettings> = _appSettings

    init {
        loadAppSettings()
    }

    private fun loadAppSettings() {
        _appSettings.value = appSettingsRepository.getAppSettings()
    }

    fun toggleDarkMode() {
        _appSettings.value = appSettingsRepository.toggleDarkMode()
    }
}
