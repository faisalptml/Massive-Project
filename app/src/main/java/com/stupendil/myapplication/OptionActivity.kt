package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.stupendil.myapplication.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity(){

    private lateinit var binding: ActivityOptionBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

       binding.btnToLogin.setOnClickListener {
           startActivity(Intent(this, LoginActivity::class.java))
       }

        binding.btnToRegist.setOnClickListener {
            startActivity(Intent(this, RegistActivity::class.java))
        }

        showGIF()
    }

    private fun showGIF() {
        val imageView:ImageView = findViewById(R.id.imageView2)
        Glide.with(this).load(R.drawable.option1).into(imageView)
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null)
            Intent(this,MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
    }

}