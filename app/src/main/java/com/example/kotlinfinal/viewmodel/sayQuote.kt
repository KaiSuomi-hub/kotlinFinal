package com.example.kotlinfinal.viewmodel
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import com.example.kotlinfinal.model.theQuote

class sayQuoteViewmodel : ViewModel() {

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun sayQuote(): String {}
    }
}