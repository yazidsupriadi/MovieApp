package com.example.movieapp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.DataEntity
import com.example.movieapp.databinding.ItemTvshowRowBinding
import com.example.movieapp.ui.detail.DetailActivity


class TvShowAdapter(private val callback: TvshowFragmentCallback) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShows = ArrayList<DataEntity>()

    fun setTvShows(tvshows: List<DataEntity>?) {
        if (tvshows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemTvshowRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvshows = listTvShows[position]
        holder.bind(tvshows)
    }

    override fun getItemCount(): Int = listTvShows.size


    class TvShowViewHolder(private val binding: ItemTvshowRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: DataEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemGenre.text = tvshow.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TVSHOW, tvshow.id)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvshow.imagePath)
                    .into(imgPoster)
            }

        }
    }

}