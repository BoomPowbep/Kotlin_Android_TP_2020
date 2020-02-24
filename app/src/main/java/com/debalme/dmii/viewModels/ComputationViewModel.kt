package com.debalme.dmii.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComputationViewModel: ViewModel() {

    private val _resultatLiveData = MutableLiveData<Double>()
    val resultatLiveData: LiveData<Double>
        get() = _resultatLiveData

    fun compute(nb1: Double, nb2: Double, operation: String) {

        _resultatLiveData.value = when(operation) {
            "MINUS" -> nb1 - nb2
            "ADD" -> nb1 + nb2
            "DIVIDE" -> nb1 / nb2
            "MULTIPLY" -> nb1 * nb2
            else -> 0.0
        }
    }
}