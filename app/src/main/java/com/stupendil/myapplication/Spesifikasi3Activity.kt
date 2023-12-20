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
import com.stupendil.myapplication.databinding.ActivitySpesifikasi3Binding

class Spesifikasi3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySpesifikasi3Binding
    private lateinit var etTypeBike: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpesifikasi3Binding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        etTypeBike = findViewById(R.id.AddType)

        val btnNextSlide: Button = findViewById(R.id.btnNextTo)
        btnNextSlide.setOnClickListener(this)

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_addMotor)
        Glide.with(this).load(R.drawable.parkingpict).into(imageView)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnNextTo -> {
                val intent = Intent(this@Spesifikasi3Activity, Spesifikasi4Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}