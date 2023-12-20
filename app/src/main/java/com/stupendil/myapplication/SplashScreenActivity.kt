package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            moveTo()
        },3000L)

    }

    private fun moveTo(){
        Intent(this, OptionActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}