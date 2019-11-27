package com.gyosanila.mymoviejetpack.di

import com.gyosanila.mymoviejetpack.core.services.RetrofitService
import com.gyosanila.mymoviejetpack.data.local.MyMovieRoomDatabase
import com.gyosanila.mymoviejetpack.data.remote.MovieServices
import com.gyosanila.mymoviejetpack.data.remote.TvShowServices
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies.FragmentFavoriteMoviesViewModel
import com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows.FragmentFavoriteTvShowsViewModel
import com.gyosanila.mymoviejetpack.features.fragmentMovie.FragmentMovieViewModel
import com.gyosanila.mymoviejetpack.features.fragmentTvShow.FragmentTvShowViewModel
import com.gyosanila.mymoviejetpack.features.movieDetail.MovieViewModel
import com.gyosanila.mymoviejetpack.features.tvShowDetail.TvShowViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by ilgaputra15
 * on Wednesday, 31/07/2019 17:41
 * Division Mobile - PT.Homecareindo Global Medika
 **/

val networkModule = module {
    single { RetrofitService.movieAPI<MovieServices>() }
    single { RetrofitService.movieAPI<TvShowServices>() }
    single { MyMovieRoomDatabase.getDatabase(androidApplication()).movieDao() }
}

val dataSourceModule = module {
    single { TvShowRepository(get(), get()) }
    single { MovieRepository(get(), get()) }
}

val viewModelModule = module {
    viewModel { FragmentMovieViewModel(get()) }
    viewModel { FragmentTvShowViewModel(get()) }
    viewModel { FragmentFavoriteMoviesViewModel(get()) }
    viewModel { FragmentFavoriteTvShowsViewModel(get()) }
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
}

val appComponent: List<Module> = listOf(dataSourceModule, networkModule, viewModelModule)