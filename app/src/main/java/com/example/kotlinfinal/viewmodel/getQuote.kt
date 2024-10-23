package com.example.kotlinfinal.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinfinal.viewmodel.sayQuoteViewmodel
import com.example.kotlinfinal.model.QuoteApi
import com.example.kotlinfinal.model.theQuote

import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class QuoteViewModel: ViewModel() {
    private val _QuoteList = MutableLiveData<theQuote>()
    val Quote: LiveData<theQuote> get() = _QuoteList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getQuote()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getQuote() {
        viewModelScope.launch {
            val quoteApi: QuoteApi?
            Log.d("quoteviewmodel", "trying!")

            try {
                Log.d("quoteviewmodel", "Getting Kanye Quote")
                quoteApi = QuoteApi.getInstance()
                val theQuote = quoteApi.getQuote()
                _QuoteList.postValue(theQuote)
                Log.d("quoteviewmodel", "got Kanye Quote")

            } catch (e: Exception) {
                Log.d("quoteviewmodel - Virhe", e.message.toString())
                _errorMessage.postValue(e.message) // Post the error message
            }
        }
    }
}