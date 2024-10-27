package com.example.kotlinfinal.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlinfinal.R

/**
 * Composable function to display the settings screen.
 *
 * @param navController The NavController used for navigation.
 * @param isDarkTheme Boolean indicating whether the dark theme is enabled.
 * @param onThemeChange Callback function to handle theme changes.
 */
@Composable
fun SettingsScreen(
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    Scaffold(
        // Top bar with the title "Settings" and navigation functionality
        topBar = { ScreenTopBar("Settings", navController) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Title text for the settings screen
                Text(text = stringResource(R.string.Settings), style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Label for the dark mode switch
                    Text(text = stringResource(R.string.dark_mode))
                    Spacer(modifier = Modifier.width(16.dp))
                    // Switch to toggle dark mode
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { onThemeChange(it) }
                    )
                }
            }
        }
    )
}