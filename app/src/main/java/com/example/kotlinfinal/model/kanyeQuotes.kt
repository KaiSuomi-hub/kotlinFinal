package com.example.kotlinfinal.model


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.kotlinfinal.viewmodel.sayQuoteViewmodel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class theQuote(
    var quote: String
)

const val BASE_URL = "https://api.kanye.rest/"

interface QuoteApi {
    @GET("quote")
    suspend fun getQuote(): theQuote

    companion object {
        private var QUOTEService: QuoteApi? = null

        @RequiresApi(Build.VERSION_CODES.O)
        fun getInstance(): QuoteApi {
            if (QUOTEService === null) {
                QUOTEService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(QuoteApi::class.java)
            }
            return QUOTEService!!
        }
    }
}
