package com.debalme.dmii.extensions

import android.widget.EditText

fun EditText.toDouble(): Double ? {
    return text.toString().toDoubleOrNull() ?: run {
        error = "N'importe quoi"
        null
    }
}
