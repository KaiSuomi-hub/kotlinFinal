package com.example.kotlinfinal.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Data class representing the response from the quote API.
 *
 * @property quote The quote text.
 */
data class QuoteResponse(val quote: String)

/**
 * Base URL for the quote API.
 */
const val BASE_URL = "https://api.kanye.rest//"

/**
 * Interface defining the quote API endpoints.
 */
interface QuoteApi {
    /**
     * Suspended function to get a quote from the API.
     *
     * @return A [QuoteResponse] containing the quote.
     */
    @GET("/")
    suspend fun getQuote(): QuoteResponse

    companion object {
        /**
         * Lazy-initialized Retrofit service for the quote API.
         */
        val quoteService: QuoteApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QuoteApi::class.java)
        }

        /**
         * Function to get an instance of the quote API service.
         *
         * @return An instance of [QuoteApi].
         */
        fun getInstance(): QuoteApi = quoteService
    }
}