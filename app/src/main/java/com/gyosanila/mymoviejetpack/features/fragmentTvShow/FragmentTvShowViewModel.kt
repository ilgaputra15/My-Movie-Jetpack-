package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import io.reactivex.disposables.Disposable

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 15:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FragmentTvShowViewModel(private val repository: TvShowRepository): ViewModel() {

    private var subscriber: Disposable? = null
    private var response: MutableLiveData<ResultResponse>? = null

    fun getTvShows(): MutableLiveData<ResultResponse>? {
        if (response == null) {
            response = MutableLiveData()
            response?.postValue(ResultResponse.OnLoading(true))
            subscriber = repository.getTvShowList()
                .subscribe(
                    { response?.postValue(ResultResponse.Success(it)) },
                    { response?.postValue(ResultResponse.Error(it)) }
                )
        }
        return response
    }
}