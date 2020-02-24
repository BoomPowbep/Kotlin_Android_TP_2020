package com.debalme.dmii.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.debalme.dmii.R
import com.debalme.dmii.extensions.toDouble
import com.debalme.dmii.viewModels.ComputationViewModel
import kotlinx.android.synthetic.main.computation_fragment.*

class ComputationFragment : Fragment() {

    val operation: String by lazy {
        arguments?.getString(ARGS_OPERATION, "addition") ?: "addition"
    }

    private lateinit var viewModel: ComputationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Le view model est rattaché au cycle de vie du fragment
        // Quand le fragment se détruit, le VM se détruit aussi
        viewModel = ViewModelProvider(this).get(ComputationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.computation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit.setOnClickListener {

            viewModel.compute(nombre1.toDouble() ?: 0.0, nombre2.toDouble() ?: 0.0, operation)

            result.text = "The result is ${viewModel.resultatLiveData.value}"
        }
    }

    companion object {
        const val ARGS_OPERATION = "ARGS_OPERATION"
        fun newInstance(operation: String):ComputationFragment {
            return ComputationFragment().apply {
                arguments = bundleOf(ARGS_OPERATION to operation)
            }
        }
    }
}