package com.gyosanila.mymoviejetpack.core.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.gyosanila.mymoviejetpack.core.utils.DialogHelper

abstract class BaseActivity: AppCompatActivity(), BaseViewInterface {

    private var dialogHelper: DialogHelper? = null
    private var isBackButtonShow = true

    override fun onStart() {
        super.onStart()
        setSupportActionBar(setToolbar())
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(isBackButtonShow)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setToolbar()?.setNavigationOnClickListener{ onBackPressed() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialogHelper = DialogHelper(this)
    }

    override fun getContext(): Context {
     return applicationContext
    }

    override fun getIntentExtra() {}

    override fun setup() {}

    abstract fun setToolbar(): Toolbar?

    override fun hideDialog() {
        dialogHelper?.hideDialog()
    }

    override fun showDialog() {
        dialogHelper?.showDialog()
    }

    override fun connectionError(error: Throwable) {
        hideDialog()
        Toast.makeText(this, "Fetch data error, ${error.message}", Toast.LENGTH_SHORT).show()
    }
}