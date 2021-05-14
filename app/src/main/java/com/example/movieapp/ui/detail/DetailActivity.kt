package com.example.movieapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.DataEntity
import com.example.movieapp.databinding.ActivityDetailBinding
class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DETAIL = "EXTRA DETAIL"
        const val EXTRA_TVSHOW = "EXTRA TVSHOW"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(activityDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_DETAIL)
            val tvshowId = extras.getString(EXTRA_TVSHOW)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)

                setMovieDetailData(viewModel.getMovie())
            }else if(tvshowId != null){
                viewModel.setSelectedTvshow(tvshowId)
                setTvShowDetailData(viewModel.getTvshow())
            }
        }

        val watch_button: Button = findViewById(R.id.btn_watch)
        watch_button.setOnClickListener(){
            Toast.makeText(this, "Hey ! Enjoy watch the film!", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun setMovieDetailData(detailMovie: DataEntity){

        val tvName: TextView = findViewById(R.id.movie_name)
        val tvDescription: TextView = findViewById(R.id.detail_description)
        val tvGenre: TextView = findViewById(R.id.detail_genre)
        val tvDirector: TextView = findViewById(R.id.detail_director)
        val ivAvatar: ImageView = findViewById(R.id.img_detail_profile)
        val tvRuntime: TextView = findViewById(R.id.detail_runtime)
        val tvRating: TextView = findViewById(R.id.detail_rating)


        supportActionBar!!.title = detailMovie.title
        if (supportActionBar != null) {
            val actionBar: ActionBar? = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(false)
        }
        tvName.text = detailMovie.title
        tvDescription.text = detailMovie.description
        Glide.with(this)
                .load(detailMovie.imagePath)
                .fitCenter()
                .into(ivAvatar)
        tvGenre.text = detailMovie.genre
        tvDirector.text = detailMovie.director
        tvRuntime.text = detailMovie.duration
        tvRating.text = detailMovie.rating
    }


    private fun setTvShowDetailData(detailTvshow: DataEntity){

        val tvName: TextView = findViewById(R.id.movie_name)
        val tvDescription: TextView = findViewById(R.id.detail_description)
        val tvGenre: TextView = findViewById(R.id.detail_genre)
        val tvDirector: TextView = findViewById(R.id.detail_director)
        val ivAvatar: ImageView = findViewById(R.id.img_detail_profile)
        val tvRuntime: TextView = findViewById(R.id.detail_runtime)
        val tvRating: TextView = findViewById(R.id.detail_rating)


        supportActionBar!!.title = detailTvshow.title
        tvName.text = detailTvshow.title
        tvDescription.text = detailTvshow.description
        Glide.with(this)
                .load(detailTvshow.imagePath)
                .fitCenter()
                .into(ivAvatar)
        tvGenre.text = detailTvshow.genre
        tvDirector.text = detailTvshow.director
        tvRuntime.text = detailTvshow.duration
        tvRating.text = detailTvshow.rating
    }

}