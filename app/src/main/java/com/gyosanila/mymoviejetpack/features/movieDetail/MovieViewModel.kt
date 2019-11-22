package com.gyosanila.mymoviejetpack.features.movieDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import io.reactivex.disposables.Disposable


class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private var subscriber: Disposable? = null
    private var response: MutableLiveData<ResultResponse>? = null

    fun getMovieById(movieId: Int): MutableLiveData<ResultResponse>? {
        if (response == null) {
            response = MutableLiveData()
            response?.postValue(ResultResponse.OnLoading(true))
            subscriber = repository.getMovieDetail(movieId)
                .subscribe(
                    { response?.postValue(ResultResponse.Success(it)) },
                    { response?.postValue(ResultResponse.Error(it)) }
                )
        }
        return response
    }
}
