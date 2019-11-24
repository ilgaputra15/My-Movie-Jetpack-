package com.gyosanila.mymoviejetpack.features.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.features.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var movieViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setupUI()
    }

    private fun setupUI() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        movieViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        movieViewModel.pagers(this)?.observe(this, Observer {
            viewPager.adapter = PagerAdapter(it, supportFragmentManager)
            tabLayout.setupWithViewPager(viewPager)
        })
    }
}
