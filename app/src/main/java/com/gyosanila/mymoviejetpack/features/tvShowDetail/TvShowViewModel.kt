package com.gyosanila.mymoviejetpack.features.tvShowDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import io.reactivex.disposables.Disposable


/**
 * Created by ilgaputra15
 * on Sunday, 09/11/2019 19:25
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class TvShowViewModel(private val repository: TvShowRepository): ViewModel() {

    private var subscriber: Disposable? = null
    private var response: MutableLiveData<ResultResponse>? = null

    fun getMovieById(movieId: Int): MutableLiveData<ResultResponse>? {
        if (response == null) {
            response = MutableLiveData()
            response?.postValue(ResultResponse.OnLoading(true))
            subscriber = repository.getTvShowDetail(movieId)
                .subscribe(
                    { response?.postValue(ResultResponse.Success(it)) },
                    { response?.postValue(ResultResponse.Error(it)) }
                )
        }
        return response
    }
}