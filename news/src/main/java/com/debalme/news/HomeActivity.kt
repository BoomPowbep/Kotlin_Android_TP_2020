package com.debalme.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.debalme.news.fragments.ArticlesFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ArticlesFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content, fragment)
            addToBackStack(null)
        }.commit()

    }
}
