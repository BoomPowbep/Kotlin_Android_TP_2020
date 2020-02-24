package com.debalme.news2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.debalme.news2.R
import com.debalme.news2.adapters.ArticleAdapter
import com.debalme.news2.viewModels.MyViewModel
import kotlinx.android.synthetic.main.articles_list_fragment.*

class ArticlesFragment : Fragment() {
    lateinit var viewModel: MyViewModel
    private val adapter = ArticleAdapter {
        val articleDetailFragment = ArticleDetailFragment.newInstance(it)
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_content, articleDetailFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.articles_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.listArticles.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })
    }
}