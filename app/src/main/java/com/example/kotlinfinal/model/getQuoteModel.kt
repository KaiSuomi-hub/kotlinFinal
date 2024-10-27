package com.example.kotlinfinal.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class QuoteResponse(val quote: String)

data class theQuote(val quote: String) {
    fun getQuote(): String {
        return quote }
}
const val BASE_URL = "https://kanye.rest"

interface QuoteApi {
    @GET("/")
    suspend fun getQuote(): QuoteResponse

    companion object {
        var quoteService: QuoteApi? = null

        fun getInstance(): QuoteApi {
            if (quoteService == null) {
                quoteService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(QuoteApi::class.java)
            }
            return quoteService!!
        }
    }
}