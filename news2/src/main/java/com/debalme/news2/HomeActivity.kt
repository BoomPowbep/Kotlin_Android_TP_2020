package com.debalme.news2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.debalme.news2.fragments.ArticlesFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragment = ArticlesFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content, fragment)
            addToBackStack(null)
        }.commit()
    }
}
