package com.example.movieapp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.movieapp.data.DataEntity
import com.example.movieapp.utils.DataDummy

class TvShowViewModel: ViewModel() {

    fun getTvShows(): List<DataEntity> = DataDummy.generateDummyTvshows()
}