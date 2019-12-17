package com.gyosanila.mymoviejetpack.features.tvShowDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.launch


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

    fun saveFavorite(movie: TvShowItem) = viewModelScope.launch {
        repository.saveFavorite(movie)
    }

    fun getFavoriteStatus(movie: TvShowItem): LiveData<TvShowItem> {
        return repository.getFavorite(movie.id)
    }

    fun deleteFavorite(movieId: Int) = viewModelScope.launch {
        repository.deleteFavorite(movieId)
    }
}