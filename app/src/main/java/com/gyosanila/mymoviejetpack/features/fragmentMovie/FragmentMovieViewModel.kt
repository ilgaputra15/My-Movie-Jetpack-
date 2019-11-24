package com.gyosanila.mymoviejetpack.features.fragmentMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import io.reactivex.disposables.Disposable

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var subscriber: Disposable? = null
    private var response: MutableLiveData<ResultResponse>? = null

    fun getListMovie(): MutableLiveData<ResultResponse>? {
        if (response == null) {
            response = MutableLiveData()
            response?.postValue(ResultResponse.OnLoading(true))
            subscriber = movieRepository.getMovieList()
                .subscribe(
                    { response?.postValue(ResultResponse.Success(it)) },
                    { response?.postValue(ResultResponse.Error(it)) }
                )
        }
        return response
    }
}