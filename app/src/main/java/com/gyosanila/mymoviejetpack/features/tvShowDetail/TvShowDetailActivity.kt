package com.gyosanila.mymoviejetpack.features.tvShowDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
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
    private var tvShowItem: TvShowItem? = null
    private lateinit var menu: Menu
    private var isFavorite: Boolean = false

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.toolbar_detail, menu)
        setIconFavorite(isFavorite)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_favorite -> {
                if (isFavorite) {
                    tvShowItem?.id?.let {
                        tvShowViewModel.deleteFavorite(it)
                        setIconFavorite(false)
                    }
                } else {
                    tvShowItem?.let {
                        tvShowViewModel.saveFavorite(it)
                        setIconFavorite(true)
                    }
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setIconFavorite(isFavorite: Boolean) {
        this.isFavorite = isFavorite
        val icon = if (isFavorite) getDrawable(R.drawable.ic_favorite_active)
        else getDrawable(R.drawable.ic_favorite)
        if (::menu.isInitialized) menu.getItem(0).icon = icon
    }

    private fun setFavorite(listMovie: TvShowItem?) {
        setIconFavorite(listMovie != null)
    }


    override fun setup() {
        tvShowItem = intent.getParcelableExtra(TV_SHOW)
        if (tvShowItem != null) {
            EspressoIdlingResource.increment()
            tvShowViewModel.getMovieById(tvShowItem?.id ?: 0)?.observe(this, Observer { response(it) })
            tvShowViewModel.getFavoriteStatus(tvShowItem!!).observe(this, Observer { setFavorite(it) })
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
