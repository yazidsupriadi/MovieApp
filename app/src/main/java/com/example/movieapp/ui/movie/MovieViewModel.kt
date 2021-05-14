package com.example.movieapp.ui.movie

import androidx.lifecycle.ViewModel
import com.example.movieapp.utils.DataDummy
import com.example.movieapp.data.DataEntity

class MovieViewModel:ViewModel() {

    fun getMovies(): List<DataEntity> = DataDummy.generateDummyMovies()

}