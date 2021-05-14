package com.example.movieapp.ui.tvshow

import com.example.movieapp.ui.movie.MovieViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest{
    private lateinit var viewModel: TvShowViewModel
    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvshows() {
        val tvshows = viewModel.getTvShows()
        assertNotNull(tvshows)
        assertEquals(10, tvshows.size)
    }
}