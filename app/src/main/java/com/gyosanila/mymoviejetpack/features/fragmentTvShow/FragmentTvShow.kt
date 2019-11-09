package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.data.model.TvShow
import com.gyosanila.mymoviejetpack.features.adapter.TvShowAdapter
import com.gyosanila.mymoviejetpack.features.tvShowDetail.TvShowDetailActivity
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * Created by ilgaputra15
 * on Thursday, 8/11/2019 16:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentTvShow : Fragment() {

    private lateinit var viewModel: FragmentTvShowViewModel
    private lateinit var listTvShow: ArrayList<TvShow>

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
        val tvShowAdapter = TvShowAdapter { itemSelected: TvShow -> listTvShowClicked(itemSelected) }
        recyclerViewTvShow.layoutManager = GridLayoutManager(activity, 2)
        recyclerViewTvShow.adapter = tvShowAdapter
        viewModel = ViewModelProviders.of(this).get(FragmentTvShowViewModel::class.java)
        listTvShow = viewModel.getTvShows()
        tvShowAdapter.setListTvShow(listTvShow)
    }

    private fun listTvShowClicked(itemSelected: TvShow) {
        val toMovieDetail = TvShowDetailActivity.generateIntent(requireContext(), itemSelected.id)
        startActivity(toMovieDetail)
    }
}