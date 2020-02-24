package com.debalme.dmii

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.debalme.dmii.fragments.ChoiceFragment
import com.debalme.dmii.fragments.LocationFragment
import com.debalme.dmii.viewModels.ComputationViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ChoiceFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content, fragment)
            addToBackStack(null)
        }.commit()
    }
}
