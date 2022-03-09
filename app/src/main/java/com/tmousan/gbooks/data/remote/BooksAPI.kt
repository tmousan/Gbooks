package com.tmousan.gbooks.data.remote

import com.tmousan.gbooks.data.local.model.BooksResponse
import com.tmousan.gbooks.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q")
        default: String = "mobile development",
        @Query ("startIndex")
        startIndex: Int = 0,
        @Query("maxResults")
        maxResults: Int = 20,
        @Query("key")
        key: String = API_KEY

    ): Response<BooksResponse>

    @GET("volumes")
    suspend fun searchBooks(
        @Query("q")
        searchQuery: String
    ):Response<BooksResponse>


}