package com.dedesaepulloh.catalogmovie.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.catalogmovie.BaseApplication
import com.dedesaepulloh.catalogmovie.R
import com.dedesaepulloh.catalogmovie.databinding.ActivityMovieBinding
import com.dedesaepulloh.catalogmovie.utils.Helper
import com.dedesaepulloh.catalogmovie.viewmodel.ViewModelFactory
import com.dedesaepulloh.catalogmovie.vo.Status
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private var activityMovieBinding: ActivityMovieBinding? = null
    private val binding get() = activityMovieBinding
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val movieViewModel: MovieViewModel by viewModels { factory }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        activityMovieBinding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.list_movie)

        val genre = intent?.getIntExtra(Helper.EXTRA_ID, 1)

        adapter = MovieAdapter()
        binding?.apply {
            rvMovie.layoutManager = GridLayoutManager(this@MovieActivity, 3)
            rvMovie.setHasFixedSize(true)
            rvMovie.adapter = adapter
        }
        if (genre != null) {
            movieViewModel.getMovie(genre).observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            movie.data?.let {
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                                Log.i("DATA : ", movie.toString())
                                showLoading(false)
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
            binding?.apply {
                rvMovie.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding?.apply {
                rvMovie.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}