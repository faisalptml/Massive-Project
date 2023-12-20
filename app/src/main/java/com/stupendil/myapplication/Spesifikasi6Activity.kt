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
import com.stupendil.myapplication.databinding.ActivitySpesifikasi6Binding

class Spesifikasi6Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySpesifikasi6Binding
    private lateinit var etLastMaint: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpesifikasi6Binding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        etLastMaint = findViewById(R.id.lastMaintAdd)

        val btnMove: Button = findViewById(R.id.btnNextTo7)
        btnMove.setOnClickListener(this)

        showGIF()

    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_addMotor)
        Glide.with(this).load(R.drawable.parkingpict).into(imageView)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnNextTo7 -> {
                val intent = Intent(this@Spesifikasi6Activity, LastMaintActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}