package com.debalme.news.repositories

import com.debalme.news.dataSources.RemoteDataSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("everything")
    fun getArticles(@Query("apiKey") apiKey:String, @Query("q") q:String = "Cats") : Call<List<Article>>
}

data class Article(val title:String = "", val description:String = "", val urlToImage:String = "")

class ArticleRepository {

    private val online = RemoteDataSource()

    fun getArticles(): List<Article> {
        return online.getRemoteArticles()
    }
}
