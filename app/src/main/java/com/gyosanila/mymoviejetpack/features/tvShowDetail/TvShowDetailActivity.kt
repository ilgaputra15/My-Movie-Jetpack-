package com.gyosanila.mymoviejetpack.features.tvShowDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.data.model.TvShow
import kotlinx.android.synthetic.main.activity_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {

    private lateinit var tvShowViewModel: TvShowViewModel

    companion object {
        const val TV_SHOW_ID = "extra_tv_show_id"
        fun generateIntent(context: Context, tvShowId: Int): Intent {
            val intent = Intent(context, TvShowDetailActivity::class.java)
            intent.putExtra(TV_SHOW_ID, tvShowId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)
        setup()
    }


    fun setup() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
        val movieId = intent.getIntExtra(TV_SHOW_ID, 0)
        if (movieId != 0) {
            tvShowViewModel.seTvShowId(movieId)
            showTvShowDetail(tvShowViewModel.getTvShowById()!!)
        }
    }

    @SuppressLint("SetTextI18n")
    fun showTvShowDetail(tvShowDetail: TvShow) {
        textTitle.text = tvShowDetail.name
        Glide.with(this)
            .load(Constant.ImageUrl+tvShowDetail.poster_path)
            .into(imageTvShow)
        textPublishAt.text = "(${tvShowDetail.first_air_date})"
        textValueGenres.text = tvShowDetail.genre_ids.toString()
        textValueOverview.text = tvShowDetail.overview
        textValueCreatedBy.text = tvShowDetail.origin_country.toString()
        textValuePopularity.text = tvShowDetail.popularity.toString()
        textValueVoteAverage.text = tvShowDetail.vote_average.toString()
    }
}
