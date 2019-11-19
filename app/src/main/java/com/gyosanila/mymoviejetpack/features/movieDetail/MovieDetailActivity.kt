package com.gyosanila.mymoviejetpack.features.movieDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.data.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel

    companion object {
        const val MOVIE_ID = "extra_movie_id"
        fun generateIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setupUI()
    }

    private fun setupUI() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        val movieId = intent.getIntExtra(MOVIE_ID, 0)
        if (movieId != 0) {
            movieViewModel.setMovieId(movieId)
            showMovieDetail(movieViewModel.getMovieById()!!)
        }
    }

    @SuppressLint("SetTextI18n")
    fun showMovieDetail(movieDetail: Movie) {
        textTitle.text = movieDetail.title
        Glide.with(this)
            .load(Constant.ImageUrl+movieDetail.poster_path)
            .into(imageMovie)
        textPublishAt.text = "(${movieDetail.release_date})"
        textValueLanguage.text = movieDetail.original_language
        textValueOverview.text = movieDetail.overview
        textValueVoteAverage.text = movieDetail.vote_average.toString()
    }
}
