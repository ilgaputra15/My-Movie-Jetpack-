package com.gyosanila.mymoviejetpack.features.favorites

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.data.model.Pager
import com.gyosanila.mymoviejetpack.features.fragmentMovie.FragmentMovie
import com.gyosanila.mymoviejetpack.features.fragmentTvShow.FragmentTvShow

/**
 * Created by ilgaputra15
 * on Sunday, 24/11/2019 21:37
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FavoritesViewModel: ViewModel() {

    var data: MutableLiveData<ArrayList<Pager>>? = null

    fun pagers(context: Context): MutableLiveData<ArrayList<Pager>>? {
        if (data == null) {
            data = MutableLiveData()
            val pager = ArrayList<Pager>()
            pager.add(Pager(context.getString(R.string.text_title_movie), FragmentMovie()))
            pager.add(Pager(context.getString(R.string.text_title_tv_show), FragmentTvShow()))
            data?.postValue(pager)
        }
        return data
    }
}