package com.dedesaepulloh.catalogmovie.ui.movie.detail.review

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.dedesaepulloh.catalogmovie.BaseApplication
import com.dedesaepulloh.catalogmovie.R
import com.dedesaepulloh.catalogmovie.databinding.ActivityWebViewReviewBinding
import com.dedesaepulloh.catalogmovie.utils.Helper

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewReviewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.detail_review)

        val review = intent?.getStringExtra(Helper.EXTRA_URL)
        binding.apply {
            mainWebview.settings.javaScriptEnabled = true
            mainWebview.loadUrl("$review")
            mainWebview.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                    if (newProgress == 100) {
                        progressBar.visibility = View.GONE
                    }
                    super.onProgressChanged(view, newProgress)
                }
            }
            mainWebview.webViewClient = MyWebViewClient()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private class MyWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        binding.apply {
            if (keyCode == KeyEvent.KEYCODE_BACK && mainWebview.canGoBack()) {
                mainWebview.goBack()
                return true
            }
            return super.onKeyDown(keyCode, event)
        }
    }
}