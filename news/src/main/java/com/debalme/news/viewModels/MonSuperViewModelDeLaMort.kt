package com.debalme.news.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.debalme.news.repositories.Article
import com.debalme.news.repositories.ArticleRepository

class MonSuperViewModelDeLaMort : ViewModel() {

    private val repository: ArticleRepository = ArticleRepository()

    private val _listArticles = MutableLiveData<List<Article>>()
    val listArticles: LiveData<List<Article>>
        get() = _listArticles

    fun loadData() {
        object : Thread() {
            override fun run() {
                val result = repository.getArticles()
                _listArticles.value = result
            }
        }.start()
    }
}
