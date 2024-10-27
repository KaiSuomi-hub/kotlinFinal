package com.example.kotlinfinal.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu

/**
 * Composable function to display the main top bar with a title and a dropdown menu.
 *
 * @param title The title to be displayed in the top bar.
 * @param infoText The text for the info menu item.
 * @param settingsText The text for the settings menu item.
 * @param navController The NavController used for navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, infoText: String, settingsText: String, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(infoText) },
                    onClick = { navController.navigate("info") }
                )
                DropdownMenuItem(
                    text = { Text(settingsText) },
                    onClick = { navController.navigate("settings") }
                )
            }
        }
    )
}

/**
 * Composable function to display a screen-specific top bar with a title and a back navigation icon.
 *
 * @param title The title to be displayed in the top bar.
 * @param navController The NavController used for navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { navController.navigateUp() }
            ) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)
            }
        }
    )
}