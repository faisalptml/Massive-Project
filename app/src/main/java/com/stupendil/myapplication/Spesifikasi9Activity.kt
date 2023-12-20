package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stupendil.myapplication.databinding.ActivitySpesifikasi8Binding
import com.stupendil.myapplication.databinding.ActivitySpesifikasi9Binding

class Spesifikasi9Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivitySpesifikasi9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpesifikasi9Binding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        val doneBtn: Button = findViewById(R.id.btnDone)
        doneBtn.setOnClickListener(this)

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_addMotor)
        Glide.with(this).load(R.drawable.notif_motor).into(imageView)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnDone -> {
                val intent = Intent(this@Spesifikasi9Activity, InputSuccessActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}