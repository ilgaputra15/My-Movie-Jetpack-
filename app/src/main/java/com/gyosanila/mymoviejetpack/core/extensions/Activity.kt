package com.gyosanila.mymoviejetpack.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gyosanila.mymoviejetpack.R

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:38
 * Division Mobile - PT.Homecareindo Global Medika
 **/


fun AppCompatActivity.changeFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.containerHome, fragment)
    transaction.commit()
}