package com.dedesaepulloh.catalogmovie.ui.genre

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dedesaepulloh.catalogmovie.data.source.local.entity.GenreEntity
import com.dedesaepulloh.catalogmovie.databinding.ItemsGenreBinding
import com.dedesaepulloh.catalogmovie.ui.movie.MovieActivity
import com.dedesaepulloh.catalogmovie.utils.Helper

class GenreAdapter : PagedListAdapter<GenreEntity, GenreAdapter.GenreViewHolder>(DIFF_CALLBACK) {

    inner class GenreViewHolder(private val binding: ItemsGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: GenreEntity) {
            binding.apply {
                tvName.text = genre.name
            }
            itemView.setOnClickListener {
                val detail = Intent(itemView.context, MovieActivity::class.java)
//                detail.putExtra(Helper.EXTRA_ID, genre.id)
                itemView.context.startActivity(detail)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GenreEntity>() {
            override fun areItemsTheSame(oldItem: GenreEntity, newItem: GenreEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GenreEntity, newItem: GenreEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val mView = ItemsGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(mView)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = getItem(position)
        if (genre != null) {
            holder.bind(genre)
        }
    }
}