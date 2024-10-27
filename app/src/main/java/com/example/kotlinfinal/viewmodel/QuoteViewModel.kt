package com.example.kotlinfinal.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinfinal.model.QuoteResponse
import com.example.kotlinfinal.model.QuoteApi
import kotlinx.coroutines.launch
import android.util.Log

/**
 * ViewModel for managing the state of quotes in the UI.
 */
class QuoteViewModel : ViewModel() {
    /**
     * State to hold the quote to be displayed.
     */
    var showableQuote = mutableStateOf("")
        private set

    /**
     * State to track the loading status.
     */
    var loading = mutableStateOf<Boolean>(false)
        private set

    /**
     * State to hold any error messages.
     */
    var error = mutableStateOf<String?>(null)
        private set

    /**
     * Initializes the ViewModel and fetches the initial quote.
     */
    init {
        fetchQuote()
    }

    /**
     * Fetches a quote from the API and updates the state accordingly.
     */
    private fun fetchQuote() {
        loading.value = true

        viewModelScope.launch {
            try {
                val quoteApi = QuoteApi.getInstance()
                val response = quoteApi.getQuote()

                Log.d("QuoteModel", "API response: $response")
                Log.d("QuoteViewModel", "Quote is : ${response.quote}")

                showableQuote.value = response.quote
            } catch (e: Exception) {
                error.value = e.message
                Log.e("QuoteViewModel", "Error fetching data: ${e.message}")
            } finally {
                loading.value = false
            }
        }
    }
}