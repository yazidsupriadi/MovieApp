package com.example.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movieapp.data.DataEntity
import com.example.movieapp.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var id: String

    fun setSelectedMovie(movieId: String) {
        this.id = movieId
    }

    fun setSelectedTvshow(tvshowId: String) {
        this.id = tvshowId
    }

    fun getMovie(): DataEntity {
        lateinit var movieData: DataEntity
        val movies = DataDummy.generateDummyMovies()
        for (movie in movies) {
            if (movie.id == id) {
                movieData = movie
            }
        }
        return movieData
    }


    fun getTvshow(): DataEntity {
        lateinit var tvshowData: DataEntity
        val tvshows = DataDummy.generateDummyTvshows()
        for (tvshow in tvshows) {
            if (tvshow.id == id) {
                tvshowData = tvshow
            }
        }
        return tvshowData
    }
}