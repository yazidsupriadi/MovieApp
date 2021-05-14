package com.example.movieapp.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.DataEntity
import com.example.movieapp.databinding.ItemMovieRowBinding
import com.example.movieapp.ui.detail.DetailActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size


    class MovieViewHolder(private val binding: ItemMovieRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                tvItemRating.text = movie.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, movie.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(movie.imagePath)
                        .into(imgPoster)
            }
        }
    }
}