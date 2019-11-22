package com.gyosanila.mymoviejetpack.features.utils

import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.TvShowItem

object FakeDataDummy {

    fun getMovieItem(): MovieItem {
        return MovieItem (
            73,
            330457,
            false,
            6.2,
            "Frozen II",
            133.013,
            "/fapXd3v9qTcNBTm39ZC4KUVQDNf.jpg",
            "en",
            "Angel Has Fallen",
            "/k2WyDw2NTUIWnuEs5gT7wgrCQg6.jpg",
            false,
            "After the events in the previous film, Secret Service agent Mike Banning finds himself framed for an assassination attempt on the President. Pursued by his own agency and the FBI, Banning races to clear his name and uncover the real terrorist threat which has set its sights on Air Force One.",
            "2019-08-21"
        )
    }

    fun getTvShowItem(): TvShowItem {
        return TvShowItem(
            82856,
            77,
            "The Mandalorian",
            7.8,
            "The Mandalorian",
            626.935,
            "/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
            "en",
            "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic."
        )
    }
}
