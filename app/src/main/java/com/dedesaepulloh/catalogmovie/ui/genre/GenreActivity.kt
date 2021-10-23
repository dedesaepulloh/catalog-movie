package com.dedesaepulloh.catalogmovie.ui.genre

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dedesaepulloh.catalogmovie.BaseApplication
import com.dedesaepulloh.catalogmovie.databinding.ActivityGenreBinding
import com.dedesaepulloh.catalogmovie.viewmodel.ViewModelFactory
import com.dedesaepulloh.catalogmovie.vo.Status
import javax.inject.Inject

class GenreActivity : AppCompatActivity() {

    private var activityGenreBinding: ActivityGenreBinding? = null
    private val binding get() = activityGenreBinding
    private lateinit var adapter: GenreAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val genreViewModel: GenreViewModel by viewModels { factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        activityGenreBinding = ActivityGenreBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        adapter = GenreAdapter()
        binding?.apply {
            rvGenre.layoutManager = GridLayoutManager(this@GenreActivity, 2)
            rvGenre.setHasFixedSize(true)
            rvGenre.adapter = adapter
        }
        loadData()
    }

    private fun loadData() {
        genreViewModel.getGenres().observe(this, { genre ->
            if (genre != null) {
                when (genre.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        genre.data?.let {
                            adapter.submitList(it)
                            adapter.notifyDataSetChanged()
                            Log.i("DATA : ", genre.toString())
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

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.apply {
                rvGenre.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        } else {
            binding?.apply {
                rvGenre.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

}