package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide

class LoadingDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_detail)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)

        showGIF()
    }

    private fun moveTo(){
        Intent(this, DetailActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_loadingCreate)
        Glide.with(this).load(R.drawable.loadingcreatepict).into(imageView)
    }
}