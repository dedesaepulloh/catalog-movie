@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.catalogmovie.ui.movie.detail.review

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.catalogmovie.R
import com.dedesaepulloh.catalogmovie.data.source.local.entity.ReviewEntity
import com.dedesaepulloh.catalogmovie.databinding.ItemsReviewBinding
import com.dedesaepulloh.catalogmovie.utils.Helper
import java.text.SimpleDateFormat

class ReviewAdapter :
    PagedListAdapter<ReviewEntity, ReviewAdapter.ReviewViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ReviewEntity>() {
            override fun areItemsTheSame(oldItem: ReviewEntity, newItem: ReviewEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ReviewEntity, newItem: ReviewEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ReviewViewHolder(private val binding: ItemsReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(review: ReviewEntity) {
            binding.apply {
                tvName.text = review.author
                tvRate.text = review.rating.toString()
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = if (review.updatedAt.isNullOrEmpty()) {
                    "${R.string.strip}"
                } else {
                    formatter.format(parser.parse(review.updatedAt))
                }
                tvUpdated.text = output
                tvContent.text = review.content
                Glide.with(itemView)
                    .load("${Helper.BASE_IMAGE_URL}${review.avatarPath}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgUser)
            }
            itemView.setOnClickListener {
                val detail = Intent(itemView.context, WebViewActivity::class.java)
                detail.putExtra(Helper.EXTRA_URL, review.url)
                itemView.context.startActivity(detail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val mView = ItemsReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = getItem(position)
        if (review != null) {
            holder.bind(review)
        }
    }
}