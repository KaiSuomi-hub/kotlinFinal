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

class MainActivity : ComponentActivity() {
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
