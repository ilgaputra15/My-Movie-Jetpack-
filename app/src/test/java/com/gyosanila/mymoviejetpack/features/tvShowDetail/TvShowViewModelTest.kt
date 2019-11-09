package com.gyosanila.mymoviejetpack.features.tvShowDetail

import com.gyosanila.mymoviejetpack.data.model.TvShow
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 20:04
 * Division Mobile - PT.Homecareindo Global Medika
 */
class TvShowViewModelTest {
    lateinit var viewModel: TvShowViewModel
    lateinit var tvShowDummy: TvShow

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
        tvShowDummy = TvShow(
            id = 1622,
            original_name = "Supernatural" ,
            genre_ids = listOf("18", "9648", "10765"),
            name = "Supernatural",
            popularity = 342.774,
            origin_country = listOf("US"),
            vote_count = 2019,
            first_air_date = "2005-09-13",
            backdrop_path = "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
            original_language = "en",
            vote_average = 7.4,
            overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
            poster_path = "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        )
    }

    @Test
    fun setTvShowId() {
        viewModel.seTvShowId(tvShowDummy.id)
        assertNotNull(viewModel.tvShowId)
        assertEquals(tvShowDummy.id, viewModel.tvShowId)
    }

    @Test
    fun getTvShowById() {
        viewModel.tvShowId = tvShowDummy.id
        val tvShow = viewModel.getTvShowById()
        assertNotNull(tvShow)
        assertEquals(tvShowDummy.id, tvShow?.id)
        assertEquals(tvShowDummy.original_name, tvShow?.original_name)
        assertEquals(tvShowDummy.genre_ids, tvShow?.genre_ids)
        assertEquals(tvShowDummy.name, tvShow?.name)
        assertEquals(tvShowDummy.popularity, tvShow?.popularity)
        assertEquals(tvShowDummy.origin_country, tvShow?.origin_country)
        assertEquals(tvShowDummy.vote_count, tvShow?.vote_count)
        assertEquals(tvShowDummy.first_air_date, tvShow?.first_air_date)
        assertEquals(tvShowDummy.backdrop_path, tvShow?.backdrop_path)
        assertEquals(tvShowDummy.original_language, tvShow?.original_language)
        assertEquals(tvShowDummy.vote_average, tvShow?.vote_average)
        assertEquals(tvShowDummy.overview, tvShow?.overview)
        assertEquals(tvShowDummy.poster_path, tvShow?.poster_path)
    }
}