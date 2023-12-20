package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide

class EditSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_success)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)

        showGIF()
    }

    private fun moveTo(){
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageViewedt)
        Glide.with(this).load(R.drawable.specificsuccesspict).into(imageView)
    }
}