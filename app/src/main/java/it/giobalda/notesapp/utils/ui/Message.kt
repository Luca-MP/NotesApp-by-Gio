package it.giobalda.notesapp.utils.ui

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import it.giobalda.notesapp.R

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showAlert(
    title: String,
    message: String,
    cancelable: Boolean = false,
    onPositiveCallback: () -> Unit = {}
) {
    AlertDialog.Builder(this)
        .setTitle(title)
        .setCancelable(cancelable)
        .setMessage(message)
        .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
            onPositiveCallback()
            dialog.dismiss()
        }
        .setNegativeButton(getString(R.string.no)) { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}

fun Context.getCustomAlert(view: View, isCancelable: Boolean = false): AlertDialog =
    AlertDialog.Builder(this)
        .setCancelable(isCancelable)
        .setView(view)
        .create()

fun View.showSnackBar(message: String, @ColorRes colorRes: Int = R.color.accent) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).apply {
        this.setBackgroundTint(
            ContextCompat.getColor(view.context, colorRes)
        )
    }.show()
}