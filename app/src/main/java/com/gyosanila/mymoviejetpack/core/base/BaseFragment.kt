package com.gyosanila.mymoviejetpack.core.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gyosanila.mymoviejetpack.core.utils.DialogHelper

/**
 * Created by ilgaputra15
 * on Saturday, 16/11/2019 13:14
 * Division Mobile - PT.Homecareindo Global Medika
 **/
abstract class BaseFragment: Fragment(), BaseViewInterface {

    private var dialogHelper: DialogHelper? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogHelper = DialogHelper(activity!!)
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

    override fun setup() {}

    override fun getIntentExtra() {}

    override fun hideDialog() {
        dialogHelper?.hideDialog()
    }

    override fun showDialog() {
        dialogHelper?.showDialog()
    }

    override fun connectionError(error: Throwable) {
        Toast.makeText(context, "Fetch data error, ${error.message}", Toast.LENGTH_SHORT).show()
    }
}