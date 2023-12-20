package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class Spesifikasi1Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spesifikasi1)

        val btnSpekNext: Button = findViewById(R.id.nextBtn)
        btnSpekNext.setOnClickListener(this)

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_addMotor)
        Glide.with(this).load(R.drawable.parkingpict).into(imageView)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.nextBtn -> {
                val intent = Intent(this@Spesifikasi1Activity, Spesifikasi2Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}