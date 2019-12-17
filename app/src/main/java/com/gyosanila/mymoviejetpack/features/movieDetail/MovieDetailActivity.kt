package com.gyosanila.mymoviejetpack.features.movieDetail

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
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceMovie
import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel


class MovieDetailActivity : BaseActivity() {

    private val movieViewModel: MovieViewModel by viewModel()
    private var movieItem: MovieItem? = null
    private lateinit var menu: Menu
    private var isFavorite: Boolean = false

    companion object {
        const val MOVIE = "extra_movie"
        fun generateIntent(context: Context, movieDetail: MovieItem): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE, movieDetail)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setupUI()
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
                    movieItem?.id?.let {
                        movieViewModel.deleteFavorite(it)
                        setIconFavorite(false)
                    }
                } else {
                    movieItem?.let {
                        movieViewModel.saveFavorite(it)
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

    private fun setupUI() {
        movieItem = intent.getParcelableExtra(MOVIE)
        if (movieItem == null) finish() else {
            EspressoIdlingResourceMovie.increment()
            movieViewModel.getMovieById(movieItem?.id ?: 0)?.observe(this, Observer { response(it) })
            movieViewModel.getFavoriteStatus(movieItem!!).observe(this, Observer { setFavorite(it) })
        }
    }

    private fun setFavorite(listMovie: MovieItem?) {
        setIconFavorite(listMovie != null)
    }

    @SuppressLint("SetTextI18n")
    fun showMovieDetail(movieDetail: MovieDetail) {
        EspressoIdlingResourceMovie.decrement()
        textTitle.text = movieDetail.title
        Glide.with(this)
            .load(Constant.ImageUrl+movieDetail.poster_path)
            .into(imageMovie)
        textPublishAt.text = "(${movieDetail.release_date})"
        textValueLanguage.text = movieDetail.original_language
        textValueOverview.text = movieDetail.overview
        textValueVoteAverage.text = movieDetail.vote_average.toString()
    }

    private fun response(result: ResultResponse) {
        when (result) {
            is ResultResponse.OnLoading -> {
                if (result.isLoading) showDialog() else hideDialog()
            }
            is ResultResponse.Success<*> -> {
                hideDialog()
                when(result.data) {
                    is MovieDetail -> {
                        showMovieDetail(result.data)
                    }
                }
            }
            is ResultResponse.Error -> {
                hideDialog()
                connectionError(result.error)
            }
        }
    }
}
