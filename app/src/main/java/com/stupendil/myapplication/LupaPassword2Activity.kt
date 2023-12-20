package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stupendil.myapplication.databinding.ActivityLupaPassword2Binding

class LupaPassword2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLupaPassword2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaPassword2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtnIn.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}