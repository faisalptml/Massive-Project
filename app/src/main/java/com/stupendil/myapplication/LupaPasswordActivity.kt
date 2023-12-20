package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import com.stupendil.myapplication.databinding.ActivityLupaPasswordBinding
import io.reactivex.Observable

class LupaPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLupaPasswordBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtnIn.setOnClickListener{
            startActivity(Intent(this, OtpActivity::class.java))
        }

        binding.moveToRegister.setOnClickListener{
            startActivity(Intent(this,RegistActivity::class.java))
        }

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.imageView4)
        Glide.with(this).load(R.drawable.loginpict).into(imageView)
    }
}