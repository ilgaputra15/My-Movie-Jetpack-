package com.gyosanila.mymoviejetpack.features.fragmentMovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseFragment
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.features.adapter.MovieAdapter
import com.gyosanila.mymoviejetpack.features.movieDetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentMovie : BaseFragment() {

    private val movieViewModel: FragmentMovieViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter

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
        movieAdapter = MovieAdapter { itemSelected: MovieItem -> listMovieClicked(itemSelected) }
        recyclerViewMovie.layoutManager = LinearLayoutManager(activity)
        recyclerViewMovie.adapter = movieAdapter
        EspressoIdlingResource.increment()
        movieViewModel.getListMovie()?.observe(this, Observer { response(it) })
    }

    private fun response(result: ResultResponse) {
        when (result) {
            is ResultResponse.OnLoading -> {
                if (result.isLoading) showDialog() else hideDialog()
            }
            is ResultResponse.Success<*> -> {
                hideDialog()
                when(result.data) {
                    is Movies -> {
                        EspressoIdlingResource.decrement()
                        movieAdapter.setListMovie(result.data.results)
                    }
                }
            }
            is ResultResponse.Error -> {
                hideDialog()
                connectionError(result.error)
            }
        }
    }

    private fun listMovieClicked(itemSelected: MovieItem) {
        val toMovieDetail = MovieDetailActivity.generateIntent(requireContext(), itemSelected)
        startActivity(toMovieDetail)
    }
}