package com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseFragment
import com.gyosanila.mymoviejetpack.core.extension.visible
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.features.adapter.FavoriteMoviesAdapter
import com.gyosanila.mymoviejetpack.features.movieDetail.MovieDetailActivity
import kotlinx.android.synthetic.main.fragment_favorites.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteMovies : BaseFragment() {

    private val movieViewModel: FragmentFavoriteMoviesViewModel by viewModel()
    private lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        favoriteMoviesAdapter = FavoriteMoviesAdapter { itemSelected: MovieItem -> listMovieClicked(itemSelected) }
        recyclerViewFavorites.layoutManager = LinearLayoutManager(activity)
        recyclerViewFavorites.adapter = favoriteMoviesAdapter
        EspressoIdlingResource.increment()
        movieViewModel.getFavoriteMovies()?.observe(this, Observer { response(it) })
    }

    private fun response(result: PagedList<MovieItem>) {
        showData(result.isNotEmpty())
        favoriteMoviesAdapter.submitList(result)
    }

    private fun showData(isShow: Boolean) {
        recyclerViewFavorites.visible = isShow
        textViewNoData.visible = !isShow
    }

    private fun listMovieClicked(itemSelected: MovieItem) {
        val toMovieDetail = MovieDetailActivity.generateIntent(requireContext(), itemSelected)
        startActivity(toMovieDetail)
    }
}