package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.base.BaseFragment
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceTvShow
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.data.model.TvShows
import com.gyosanila.mymoviejetpack.features.adapter.TvShowAdapter
import com.gyosanila.mymoviejetpack.features.tvShowDetail.TvShowDetailActivity
import kotlinx.android.synthetic.main.fragment_tv_show.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentTvShow : BaseFragment() {

    private val viewModel: FragmentTvShowViewModel by viewModel()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        tvShowAdapter = TvShowAdapter { itemSelected: TvShowItem -> listTvShowClicked(itemSelected) }
        recyclerViewTvShow.layoutManager = GridLayoutManager(activity, 2)
        recyclerViewTvShow.adapter = tvShowAdapter
        EspressoIdlingResourceTvShow.increment()
        viewModel.getTvShows()?.observe(this, Observer { response(it) })
    }

    private fun response(result: ResultResponse) {
        when (result) {
            is ResultResponse.OnLoading -> {
                if (result.isLoading) showDialog() else hideDialog()
            }
            is ResultResponse.Success<*> -> {
                hideDialog()
                when(result.data) {
                    is TvShows -> {
                        EspressoIdlingResourceTvShow.decrement()
                        tvShowAdapter.setListTvShow(result.data.results)
                    }
                }
            }
            is ResultResponse.Error -> {
                hideDialog()
                connectionError(result.error)
            }
        }
    }

    private fun listTvShowClicked(itemSelected: TvShowItem) {
        val toMovieDetail = TvShowDetailActivity.generateIntent(requireContext(), itemSelected)
        startActivity(toMovieDetail)
    }
}