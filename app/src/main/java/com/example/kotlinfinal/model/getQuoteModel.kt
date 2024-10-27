package com.example.kotlinfinal.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class QuoteResponse(val quote: String)

data class TheQuote(val quote: String)

const val BASE_URL = "https://kanye.rest"

interface QuoteApi {
    @GET("/")
    suspend fun getQuote(): QuoteResponse

    companion object {
        private val quoteService: QuoteApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuoteApi::class.java)
        }

        fun getInstance(): QuoteApi = quoteService
    }
}