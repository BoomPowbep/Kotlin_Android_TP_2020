package com.debalme.news2.repositories

import com.debalme.news2.dataSources.RemoteDataSource
import com.debalme.news2.models.Article

class Repository {
    private val online = RemoteDataSource()

    fun getArticles(): List<Article> {
        return online.getRemoteArticles()
    }

}