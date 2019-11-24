package com.gyosanila.mymoviejetpack.data.repository

import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.core.utils.RxUtils
import com.gyosanila.mymoviejetpack.data.model.TvShowDetail
import com.gyosanila.mymoviejetpack.data.model.TvShows
import com.gyosanila.mymoviejetpack.data.remote.TvShowServices
import io.reactivex.Observable

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 13:51
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class TvShowRepository(private val tvShowApi: TvShowServices) {

    fun getTvShowList() : Observable<TvShows> {
        return tvShowApi.getListTvShow(Constant.MovieAPIKey, 1).compose(RxUtils.applyObservableAsync())
    }

    fun getTvShowDetail(id: Int) : Observable<TvShowDetail> {
        return tvShowApi.getTvShowDetail(id, Constant.MovieAPIKey).compose(RxUtils.applyObservableAsync())
    }
}