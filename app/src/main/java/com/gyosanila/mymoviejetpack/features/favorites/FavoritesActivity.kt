package com.gyosanila.mymoviejetpack.features.favorites

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseActivity
import com.gyosanila.mymoviejetpack.features.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.activity_favorites.tabLayout

/**
 * Created by ilgaputra15
 * on Sunday, 24/11/2019 21:33
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FavoritesActivity: BaseActivity() {

    private lateinit var movieViewModel: FavoritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        setup()
    }

    override fun setToolbar(): Toolbar? = toolbar

    override fun setup() {
        super.setup()
        movieViewModel = ViewModelProviders.of(this).get(FavoritesViewModel::class.java)
        movieViewModel.pagers(this)?.observe(this, Observer {
            viewPagerFavorites.adapter = PagerAdapter(it, supportFragmentManager)
            tabLayout.setupWithViewPager(viewPagerFavorites)
        })
    }
}