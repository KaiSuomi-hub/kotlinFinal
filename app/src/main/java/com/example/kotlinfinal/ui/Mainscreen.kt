package com.example.kotlinfinal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.kotlinfinal.R
import com.example.kotlinfinal.ui.QuoteScreen

/**
 * Composable function to display the main screen of the application.
 *
 * @param navController The NavController used for navigation.
 */
@Composable
fun MainScreen(navController: NavController) {
    // Retrieve the text for the info and settings menu items from resources
    val infoText = stringResource(R.string.info)
    val settingsText = stringResource(R.string.Settings)

    Scaffold(
        // Set up the top bar with the title and menu items
        topBar = { MainTopBar(title = stringResource(R.string.title), infoText = infoText, settingsText = settingsText, navController = navController) },
        // Set up the content area with padding
        content = { innerPadding -> QuoteScreen(modifier = Modifier.padding(innerPadding))},
    )
}