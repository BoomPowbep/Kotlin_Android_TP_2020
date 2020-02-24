package com.debalme.dmii.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.debalme.dmii.R
import kotlinx.android.synthetic.main.choice_fragment.*

class ChoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choice_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        minusButton.setOnClickListener {
            val computationFragment = ComputationFragment.newInstance("MINUS")

            activity!!.supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_content, computationFragment)
                addToBackStack(null)
            }.commit()
        }

        sumButton.setOnClickListener {
            val computationFragment = ComputationFragment.newInstance("ADD")

            activity!!.supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_content, computationFragment)
                addToBackStack(null)
            }.commit()
        }

        multiplyButton.setOnClickListener {
            val computationFragment = ComputationFragment.newInstance("MULTIPLY")

            activity!!.supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_content, computationFragment)
                addToBackStack(null)
            }.commit()
        }

        divButton.setOnClickListener {
            val computationFragment = ComputationFragment.newInstance("DIVIDE")

            activity!!.supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_content, computationFragment)
                addToBackStack(null)
            }.commit()
        }
    }

}
