package com.debalme.news.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.debalme.news.R
import com.debalme.news.viewModels.MonSuperViewModelDeLaMort
import kotlinx.android.synthetic.main.articles_layout.*

class ArticlesFragment : Fragment() {

    lateinit var viewModel: MonSuperViewModelDeLaMort

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.articles_layout, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MonSuperViewModelDeLaMort::class.java)
        viewModel.loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)

//        recyclerView.adapter = adapterRecycler
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.listArticles.observe(viewLifecycleOwner, Observer {
            Log.v("TITLE", it[0].title)
        })
    }
}
