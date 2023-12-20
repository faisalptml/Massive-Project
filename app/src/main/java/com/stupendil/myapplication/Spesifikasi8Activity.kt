package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.stupendil.myapplication.databinding.ActivitySpesifikasi8Binding

class Spesifikasi8Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySpesifikasi8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpesifikasi8Binding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        val btnMoveSlide: Button = findViewById(R.id.btnMovementSlide)
        btnMoveSlide.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnMovementSlide -> {
                val intent = Intent(this@Spesifikasi8Activity, Spesifikasi9Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}