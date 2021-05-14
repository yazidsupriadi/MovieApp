package com.example.movieapp.ui.detail

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import com.example.movieapp.utils.DataDummy

class DetailViewModelTest {


    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id
    private val dummyTvshow = DataDummy.generateDummyTvshows()[0]
    private val tvshowId = dummyTvshow.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvshow(tvshowId)
    }
    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.id)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
    }

    @Test
    fun getTvshow() {

        viewModel.setSelectedMovie(dummyTvshow.id)
        val tvshowEntity = viewModel.getTvshow()
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.id, tvshowEntity.id)
        assertEquals(dummyTvshow.title, tvshowEntity.title)
        assertEquals(dummyTvshow.description, tvshowEntity.description)
        assertEquals(dummyTvshow.genre, tvshowEntity.genre)
        assertEquals(dummyTvshow.duration, tvshowEntity.duration)
        assertEquals(dummyTvshow.rating, tvshowEntity.rating)
        assertEquals(dummyTvshow.imagePath, tvshowEntity.imagePath)
    }
}