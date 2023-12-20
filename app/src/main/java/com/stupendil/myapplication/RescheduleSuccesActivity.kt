package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide

class RescheduleSuccesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reschedule_succes)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageSchedule)
        Glide.with(this).load(R.drawable.reschedulesuccesspict).into(imageView)
    }

    private fun moveTo() {
        Intent(this, DetailActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}