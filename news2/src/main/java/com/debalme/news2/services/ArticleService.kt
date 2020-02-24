package com.debalme.news2.services

import com.debalme.news2.models.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("everything")
    fun getArticles(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String = "taxi"
    ): Call<ArticleResponse>
}