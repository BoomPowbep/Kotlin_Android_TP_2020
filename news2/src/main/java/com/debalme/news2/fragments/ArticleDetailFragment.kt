package com.debalme.news2.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.debalme.news2.R
import com.debalme.news2.models.Article
import com.debalme.news2.viewModels.MyViewModel
import kotlinx.android.synthetic.main.article_detail_fragment.*

class ArticleDetailFragment: Fragment() {
    private lateinit var viewModel: MyViewModel

    val article: Article by lazy {
        arguments?.getParcelable<Article>("article")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        return inflater.inflate(R.layout.article_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article_title.text = article.title
        article_author.text = article.author

        share.setOnClickListener { navigateToBrowser() }
    }

    private fun navigateToBrowser() {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse(article.url)
        startActivity(openURL)
    }

    companion object {
        fun newInstance(article: Article): ArticleDetailFragment {
            return ArticleDetailFragment().apply {
                arguments = bundleOf("article" to article)
            }
        }
    }
}
