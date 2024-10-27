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

@Composable
fun QuoteScreen(viewModel: QuoteViewModel = viewModel(), modifier: Modifier = Modifier) {

    val Quote by remember { viewModel.showableQuote }
    val loading by remember { viewModel.loading }
    val error by remember { viewModel.error }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when {
            loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(44.dp)
                            .padding(16.dp)
                    )
                }
            }
            error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.API_error), style = MaterialTheme.typography.bodyLarge)
                }
            }
            Quote.isNotEmpty() -> {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        QuoteItem(Quote)
                    }
                }
            }
            else -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = stringResource(R.string.no_quotes), style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}