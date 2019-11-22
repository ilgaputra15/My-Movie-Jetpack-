package com.gyosanila.mymoviejetpack.features.movieDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseActivity
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel


class MovieDetailActivity : BaseActivity() {

    private val movieViewModel: MovieViewModel by viewModel()

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

    private fun setupUI() {
        val movie = intent.getParcelableExtra<MovieItem>(MOVIE)
        if (movie == null) finish() else {
            EspressoIdlingResource.increment()
            movieViewModel.getMovieById(movie.id)?.observe(this, Observer { response(it) })
        }
    }

    @SuppressLint("SetTextI18n")
    fun showMovieDetail(movieDetail: MovieDetail) {
        EspressoIdlingResource.decrement()
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
