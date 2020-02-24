package com.debalme.news2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val title: String,
    val description: String,
    val author: String,
    val url: String,
    val urlToImage: String,
    var liked: Boolean = false
) : Parcelable

data class ArticleResponse(val status:String, val totalResults:Int, val articles:List<Article>)
