package com.gyosanila.mymoviejetpack.features.fragmentMovie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.data.model.Movie
import com.gyosanila.mymoviejetpack.features.adapter.MovieAdapter
import com.gyosanila.mymoviejetpack.features.movieDetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentMovie : Fragment() {

    private lateinit var movieViewModel: FragmentMovieViewModel
    private lateinit var movieList: ArrayList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val movieAdapter = MovieAdapter { itemSelected: Movie -> listMovieClicked(itemSelected) }
        recyclerViewMovie.layoutManager = LinearLayoutManager(activity)
        recyclerViewMovie.adapter = movieAdapter
        movieViewModel = ViewModelProviders.of(this).get(FragmentMovieViewModel::class.java)
        movieList = movieViewModel.getMovies()
        movieAdapter.setListMovie(movieList)
    }

    private fun listMovieClicked(itemSelected: Movie) {
        val toMovieDetail = MovieDetailActivity.generateIntent(requireContext(), itemSelected.id)
        startActivity(toMovieDetail)
    }
}