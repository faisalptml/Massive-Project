package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stupendil.myapplication.databinding.ActivitySpesifikasi4Binding

class Spesifikasi4Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySpesifikasi4Binding
    private lateinit var etSeriBike: EditText


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mBinding = ActivitySpesifikasi4Binding.inflate(LayoutInflater.from(this))
            setContentView(mBinding.root)

            etSeriBike = findViewById(R.id.seriAdd)

            val btnNextSlide: Button = findViewById(R.id.btnNextTo5)
            btnNextSlide.setOnClickListener(this)

            showGIF()
        }

        private fun showGIF() {
            val imageView: ImageView = findViewById(R.id.iv_addMotor)
            Glide.with(this).load(R.drawable.parkingpict).into(imageView)
        }

        override fun onClick(v: View) {
            when(v.id){
                R.id.btnNextTo5 -> {
                    val intent = Intent(this@Spesifikasi4Activity, Spesifikasi5Activity::class.java)
                    startActivities(arrayOf(intent))
                }
            }
        }
}