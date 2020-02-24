package com.debalme.news2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debalme.news2.models.Article
import com.debalme.news2.repositories.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private val _listArticles = MutableLiveData<List<Article>>()
    val listArticles: LiveData<List<Article>>
        get() = _listArticles

    fun like(article: Article) {
        article.liked = !article.liked
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getArticles()
            _listArticles.postValue(result)
        }

    }
}
