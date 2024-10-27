package com.example.kotlinfinal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kotlinfinal.viewmodel.QuoteViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinfinal.R

/**
 * Composable function to display the Quote screen.
 *
 * @param viewModel The ViewModel that provides the data for the UI.
 * @param modifier The modifier to be applied to the layout.
 */
@Composable
fun QuoteScreen(viewModel: QuoteViewModel = viewModel(), modifier: Modifier = Modifier) {

    // State variables to hold the quote, loading status, and error message
    val quote by remember { viewModel.showableQuote }
    val loading by remember { viewModel.loading }
    val error by remember { viewModel.error }

    // Surface to provide a background color for the screen
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when {
            // Display a loading indicator when data is being fetched
            loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(16.dp)
                    )
                }
            }
            // Display an error message if there was an error fetching data
            error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.API_error), style = MaterialTheme.typography.bodyLarge)
                }
            }
            // Display the quote if it is not empty
            quote.isNotEmpty() -> {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        QuoteItem(quote)
                    }
                }
            }
            // Display a message if there are no quotes
            else -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.no_quotes), style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}