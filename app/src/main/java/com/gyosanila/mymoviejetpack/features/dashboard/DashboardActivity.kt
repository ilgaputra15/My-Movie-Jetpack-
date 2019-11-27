package com.gyosanila.mymoviejetpack.features.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.features.adapter.PagerAdapter
import com.gyosanila.mymoviejetpack.features.favorites.FavoritesActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var movieViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setupUI()
    }

    private fun setupUI() {
        setSupportActionBar(toolbar)
        fab.setOnClickListener(this)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        movieViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        movieViewModel.pagers(this)?.observe(this, Observer {
            viewPager.adapter = PagerAdapter(it, supportFragmentManager)
            tabLayout.setupWithViewPager(viewPager)
        })
    }

    override fun onClick(view: View?) {
        when (view) {
            fab -> navigateToFavoriteView()
        }
    }

    private fun navigateToFavoriteView() {
        startActivity(Intent(this, FavoritesActivity::class.java))
    }
}
