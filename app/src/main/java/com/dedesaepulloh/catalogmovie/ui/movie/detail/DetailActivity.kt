@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.dedesaepulloh.catalogmovie.ui.movie.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dedesaepulloh.catalogmovie.BaseApplication
import com.dedesaepulloh.catalogmovie.R
import com.dedesaepulloh.catalogmovie.data.source.local.entity.MovieEntity
import com.dedesaepulloh.catalogmovie.databinding.ActivityDetailBinding
import com.dedesaepulloh.catalogmovie.utils.Helper
import com.dedesaepulloh.catalogmovie.viewmodel.ViewModelFactory
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail_movie)

        showLoading(true)
        val movie = intent?.getIntExtra(Helper.EXTRA_ID, 1)
        if (movie != null) {
            detailViewModel.getMoviesById(movie).observe(this, {
                movieLoadData(it)
                showLoading(false)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    @SuppressLint("SimpleDateFormat")
    private fun movieLoadData(data: MovieEntity?) {
        data?.apply {
            activityDetailBinding.itemDetail.apply {
                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                val output: String = if (release_date.isNullOrEmpty()) {
                    getString(R.string.strip)
                } else {
                    formatter.format(parser.parse(release_date))
                }
                tvTitle.text = original_title
                tvRelease.text = output
                tvPopularity.text = popularity.toString()
                tvRate.text = vote_average.toString()
                tvOverview.text = overview
                tvVote.text = vote_count.toString()
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${poster_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(riPoster)
                Glide.with(this@DetailActivity)
                    .load("${Helper.BASE_IMAGE_URL}${backdrop_path}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_image)
                    .into(imgBackdrop)
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            activityDetailBinding.itemDetail.apply {
                progressBar.visibility = View.VISIBLE
                labelRelease.visibility = View.GONE
                labelPopularity.visibility = View.GONE
                labelRate.visibility = View.GONE
                tvOverview.visibility = View.GONE
                tvTitle.visibility = View.GONE
                tvRelease.visibility = View.GONE
                tvPopularity.visibility = View.GONE
                tvRate.visibility = View.GONE
                labelOverview.visibility = View.GONE
                labelVote.visibility = View.GONE
                tvVote.visibility = View.GONE
                labelBackdrop.visibility = View.GONE
            }

        } else {
            activityDetailBinding.itemDetail.apply {
                progressBar.visibility = View.GONE
                labelRelease.visibility = View.VISIBLE
                labelPopularity.visibility = View.VISIBLE
                labelRate.visibility = View.VISIBLE
                tvOverview.visibility = View.VISIBLE
                tvTitle.visibility = View.VISIBLE
                tvRelease.visibility = View.VISIBLE
                tvPopularity.visibility = View.VISIBLE
                tvRate.visibility = View.VISIBLE
                labelOverview.visibility = View.VISIBLE
                labelVote.visibility = View.VISIBLE
                tvVote.visibility = View.VISIBLE
                labelBackdrop.visibility = View.VISIBLE
            }
        }
    }

}