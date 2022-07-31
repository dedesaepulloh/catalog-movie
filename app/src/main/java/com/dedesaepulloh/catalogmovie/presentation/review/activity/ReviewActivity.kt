package com.dedesaepulloh.catalogmovie.presentation.review.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dedesaepulloh.catalogmovie.BaseApplication
import com.dedesaepulloh.catalogmovie.R
import com.dedesaepulloh.catalogmovie.databinding.ActivityReviewBinding
import com.dedesaepulloh.catalogmovie.presentation.detail.DetailViewModel
import com.dedesaepulloh.catalogmovie.utils.Helper
import com.dedesaepulloh.catalogmovie.presentation.ViewModelFactory
import com.dedesaepulloh.catalogmovie.presentation.review.adapter.ReviewAdapter
import com.dedesaepulloh.catalogmovie.utils.Status
import javax.inject.Inject

class ReviewActivity : AppCompatActivity() {

    private lateinit var activityReviewBinding: ActivityReviewBinding
    private lateinit var adapter: ReviewAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        activityReviewBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(activityReviewBinding.root)

        val movie = intent?.getIntExtra(Helper.EXTRA_ID, 1)
        val title = intent.getStringExtra("title") ?: ""

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "${getString(R.string.review)} - $title"

        showLoading(true)
        adapter = ReviewAdapter()
        activityReviewBinding.apply {
            val layoutManager = LinearLayoutManager(this@ReviewActivity)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            rvReview.layoutManager = layoutManager
            rvReview.setHasFixedSize(true)
            rvReview.adapter = adapter
        }

        Log.i("Review ID Movie ", movie.toString())
        if (movie != null) {
            detailViewModel.getReview(movie).observe(this, { review ->
                if (review != null) {
                    when (review.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            review.data?.let {
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                                Log.i("Review Data ", it.toString())
                                showLoading(false)
                                if (it.size > 0) {
                                    isEmptyReview(false)
                                } else {
                                    isEmptyReview(true)
                                }
                            }
                        }
                        Status.ERROR -> {
                            showLoading(false)
                        }
                    }
                }
            })
        }


    }

    private fun showLoading(state: Boolean) {
        if (state) {
            activityReviewBinding.apply {
                progressBar.visibility = View.VISIBLE
                rvReview.visibility = View.GONE
            }

        } else {
            activityReviewBinding.apply {
                progressBar.visibility = View.GONE
                rvReview.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun isEmptyReview(state: Boolean) {
        if (state) {
            activityReviewBinding.reviewEmpty.apply {
                imgEmpty.visibility = View.VISIBLE
                tvEmpty.text = getString(R.string.no_reviews)
                tvEmpty.visibility = View.VISIBLE
                parentEmpty.visibility = View.VISIBLE
            }
            activityReviewBinding.rvReview.visibility = View.GONE
        } else {
            activityReviewBinding.reviewEmpty.apply {
                imgEmpty.visibility = View.GONE
                tvEmpty.visibility = View.GONE
                parentEmpty.visibility = View.GONE
            }
            activityReviewBinding.rvReview.visibility = View.VISIBLE
        }
    }

}