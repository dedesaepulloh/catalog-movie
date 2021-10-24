package com.dedesaepulloh.catalogmovie.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.databinding.ItemsMovieBinding
import com.dedesaepulloh.catalogmovie.ui.movie.detail.DetailActivity
import com.dedesaepulloh.catalogmovie.utils.Helper


class MovieAdapter :
    PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            binding.apply {
                tvVote.text = movie.vote_average.toString()
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${movie.poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(com.dedesaepulloh.catalogmovie.R.drawable.ic_image)
                    .into(imgPoster)
            }
            itemView.setOnClickListener {
                val detail = Intent(itemView.context, DetailActivity::class.java)
                detail.putExtra(Helper.EXTRA_ID, movie.movieId)
                itemView.context.startActivity(detail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val mView = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

}