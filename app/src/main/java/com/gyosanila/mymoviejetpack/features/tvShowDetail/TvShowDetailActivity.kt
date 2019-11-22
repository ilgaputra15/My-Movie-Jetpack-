package com.gyosanila.mymoviejetpack.features.tvShowDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseActivity
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.model.TvShowDetail
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import kotlinx.android.synthetic.main.activity_tv_show_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class TvShowDetailActivity : BaseActivity() {

    private val tvShowViewModel: TvShowViewModel by viewModel()

    companion object {
        const val TV_SHOW = "extra_tv_show"
        fun generateIntent(context: Context, tvShowId: TvShowItem): Intent {
            val intent = Intent(context, TvShowDetailActivity::class.java)
            intent.putExtra(TV_SHOW, tvShowId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)
        setup()
    }

    override fun setToolbar(): Toolbar? = toolbar


    override fun setup() {
//        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
        val tvShow = intent.getParcelableExtra<TvShowItem>(TV_SHOW)
        if (tvShow != null) {
            EspressoIdlingResource.increment()
            tvShowViewModel.getMovieById(tvShow.id)?.observe(this, Observer { response(it) })
        } else finish()
    }

    private fun response(result: ResultResponse) {
        when (result) {
            is ResultResponse.OnLoading -> {
                if (result.isLoading) showDialog() else hideDialog()
            }
            is ResultResponse.Success<*> -> {
                hideDialog()
                when(result.data) {
                    is TvShowDetail -> {
                        showTvShowDetail(result.data)
                    }
                }
            }
            is ResultResponse.Error -> {
                hideDialog()
                connectionError(result.error)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun showTvShowDetail(tvShowDetail: TvShowDetail) {
        EspressoIdlingResource.decrement()
        textTitle.text = tvShowDetail.name
        Glide.with(this)
            .load(Constant.ImageUrl+tvShowDetail.poster_path)
            .into(imageTvShow)
        textPublishAt.text = "(${tvShowDetail.first_air_date})"
        textValueGenres.text = tvShowDetail.genres.joinToString { it.name }
        textValueOverview.text = tvShowDetail.overview
        textValueCreatedBy.text = tvShowDetail.origin_country.joinToString { it }
        textValuePopularity.text = tvShowDetail.popularity.toString()
        textValueVoteAverage.text = tvShowDetail.vote_average.toString()
    }
}
