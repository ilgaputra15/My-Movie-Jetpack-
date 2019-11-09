package com.gyosanila.mymoviejetpack.features.movieDetail

import com.gyosanila.mymoviejetpack.data.model.Movie
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:57
 * Division Mobile - PT.Homecareindo Global Medika
 */
class MovieViewModelTest {
    lateinit var viewModel: MovieViewModel
    lateinit var movieDummy: Movie

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
        movieDummy = Movie(
            id = 290859,
            title = "Terminator: Dark Fate",
            poster_path = "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
            original_language = "en",
            original_title = "Terminator: Dark Fate",
            vote_average =  6.6,
            overview = "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
            release_date = "2019-11-01"

        )
    }

    @Test
    fun setMovieId() {
        viewModel.setMovieId(movieDummy.id)
        assertNotNull(viewModel.movieId)
        assertEquals(movieDummy.id, viewModel.movieId)
    }

    @Test
    fun getMovieById() {
        viewModel.movieId = movieDummy.id
        val movie = viewModel.getMovieById()
        assertNotNull(movie)
        assertEquals(movieDummy.id, movie?.id)
        assertEquals(movieDummy.title, movie?.title)
        assertEquals(movieDummy.overview, movie?.overview)
        assertEquals(movieDummy.original_language, movie?.original_language)
        assertEquals(movieDummy.original_title, movie?.original_title)
        assertEquals(movieDummy.vote_average, movie?.vote_average)
        assertEquals(movieDummy.release_date, movie?.release_date)
    }


}