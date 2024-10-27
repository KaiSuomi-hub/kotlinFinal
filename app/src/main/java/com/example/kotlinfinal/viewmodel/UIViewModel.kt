package com.example.kotlinfinal.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * ViewModel for managing UI-related data in a lifecycle-conscious way.
 */
class UiViewModel : ViewModel() {
    /**
     * State to track whether the dark theme is enabled.
     */
    var isDarkTheme = mutableStateOf(false)
        private set

    /**
     * Toggles the theme between dark and light modes.
     *
     * @param isDark Boolean indicating whether the dark theme should be enabled.
     */
    fun toggleTheme(isDark: Boolean) {
        isDarkTheme.value = isDark
    }
}