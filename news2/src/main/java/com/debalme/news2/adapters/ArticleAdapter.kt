package com.debalme.news2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.debalme.news2.R
import com.debalme.news2.models.Article

class ArticleAdapter(val handler: (article: Article)->Unit) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private val dataset: MutableList<Article> = mutableListOf()

    inner class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.single_article_title)
            val txtDesc = root.findViewById<TextView>(R.id.single_article_description)
            val articleImage = root.findViewById<ImageView>(R.id.single_article_image)
            txtTitle.text = item.title
            txtDesc.text = item.description

            Glide.with(root)
                .load(item.urlToImage)
                .into(articleImage)

            root.setOnClickListener {
                handler(item)
            }
        }
    }

    fun updateData(list: List<Article>) {
        dataset.clear()
        dataset.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_article_list, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}