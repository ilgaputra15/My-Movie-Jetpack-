package com.gyosanila.mymoviejetpack.features.movieDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.launch


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

    fun saveFavorite(movie: MovieItem) = viewModelScope.launch {
        repository.saveFavorite(movie)
    }

    fun getFavoriteStatus(movie: MovieItem): LiveData<MovieItem> {
        return repository.getFavorite(movie.id)
    }

    fun deleteFavorite(movieId: Int) = viewModelScope.launch {
        repository.deleteFavorite(movieId)
    }
}
