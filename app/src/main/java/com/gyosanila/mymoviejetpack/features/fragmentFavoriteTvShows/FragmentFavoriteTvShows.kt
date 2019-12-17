package com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseFragment
import com.gyosanila.mymoviejetpack.core.extension.visible
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceTvShow
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.features.adapter.FavoriteTvShowsAdapter
import com.gyosanila.mymoviejetpack.features.tvShowDetail.TvShowDetailActivity
import kotlinx.android.synthetic.main.fragment_favorite_tv_shows.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteTvShows : BaseFragment() {

    private val viewModel: FragmentFavoriteTvShowsViewModel by viewModel()
    private lateinit var tvShowAdapter: FavoriteTvShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_tv_shows, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        tvShowAdapter = FavoriteTvShowsAdapter { itemSelected: TvShowItem -> listTvShowClicked(itemSelected) }
        recyclerViewFavoriteTvShows.layoutManager = GridLayoutManager(activity, 2)
        recyclerViewFavoriteTvShows.adapter = tvShowAdapter
        EspressoIdlingResourceTvShow.increment()
        viewModel.getFavoriteTvShows()?.observe(this, Observer { response(it) })
    }

    private fun response(result: PagedList<TvShowItem>) {
        EspressoIdlingResourceTvShow.decrement()
        showData(result.isNotEmpty())
        tvShowAdapter.submitList(result)
    }

    private fun showData(isShow: Boolean) {
        recyclerViewFavoriteTvShows.visible = isShow
        textViewNoDataTvShow.visible = !isShow
    }

    private fun listTvShowClicked(itemSelected: TvShowItem) {
        val toTvShowDetail = TvShowDetailActivity.generateIntent(requireContext(), itemSelected)
        startActivity(toTvShowDetail)
    }
}