package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class LoadingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)

        val btnSkip: TextView = findViewById(R.id.tv_skip)
        btnSkip.setOnClickListener(this)

        showGIF()
    }

    private fun moveTo(){
        Intent(this, Spesifikasi1Activity::class.java).also {
            startActivity(it)
            finish()
        }
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.loadingRegist)
        Glide.with(this).load(R.drawable.loadingregistpict).into(imageView)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.tv_skip -> {
                val intent = Intent(this@LoadingActivity, Spesifikasi1Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}