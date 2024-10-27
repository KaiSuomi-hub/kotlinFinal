package com.example.kotlinfinal.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinfinal.ui.theme.KotlinFinalTheme
import com.example.kotlinfinal.viewmodel.UiViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinfinal.ui.MainScreen
import com.example.kotlinfinal.ui.SettingsScreen
import com.example.kotlinfinal.ui.InfoScreen

/**
 * Main activity for the application.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiViewModel: UiViewModel = viewModel()

            KotlinFinalTheme(darkTheme = uiViewModel.isDarkTheme.value) {
                QuoteApp(uiViewModel = uiViewModel)
            }
        }
    }
}

/**
 * Composable function to set up the navigation for the Quote application.
 *
 * @param uiViewModel The ViewModel that provides the UI state.
 */
@Composable
fun QuoteApp(uiViewModel: UiViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { MainScreen(navController) }
        composable("info") { InfoScreen(navController) }
        composable("settings") {
            SettingsScreen(
                navController = navController,
                isDarkTheme = uiViewModel.isDarkTheme.value,
                onThemeChange = { uiViewModel.toggleTheme(it) },
            )
        }
    }
}