package com.debalme.news.dataSources

import com.debalme.news.BuildConfig
import com.debalme.news.repositories.Article
import com.debalme.news.repositories.ArticleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RemoteDataSource {
    private val service: ArticleService

    init {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().apply {
            //Ajouter un converter pour JSON
            //Ici on utilise gson
            addConverterFactory(GsonConverterFactory.create())
            client(client)
            //Ajouter l'url de base du web service
            baseUrl("https://newsapi.org/v2/")
        }.build()
        //Créer une instance du service
        service = retrofit.create(ArticleService::class.java)
    }

    fun getRemoteArticles(): List<Article> {
        val result = service.getArticles(apiKey = "a0d8bbea50f74cb5aef5dd33bd55a9e0").execute()
        return if (result.isSuccessful) {
            result.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}
