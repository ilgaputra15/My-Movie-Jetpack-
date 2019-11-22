package com.gyosanila.mymoviejetpack.core.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.gyosanila.mymoviejetpack.R

class DialogHelper(private val activity: Activity) {

    private var dialog: AlertDialog? = null

    @SuppressLint("InflateParams")
    fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(activity)
        val dialogView = LayoutInflater.from(activity).inflate(R.layout.dialog_loading, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        dialog = dialogBuilder.create()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.show()
    }

    fun hideDialog() {
        dialog?.dismiss()
    }
}