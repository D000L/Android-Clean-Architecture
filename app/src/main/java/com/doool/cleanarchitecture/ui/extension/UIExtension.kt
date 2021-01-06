package com.doool.cleanarchitecture.ui.extension

import android.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showDialog(message: String) {
    AlertDialog.Builder(context).apply {
        setMessage(message)
        setPositiveButton("OK") { dialog, btnId ->
            dialog.dismiss()
        }
    }.show()
}