package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.stupendil.myapplication.databinding.ActivityLocationBinding
import com.stupendil.myapplication.databinding.ActivityProfileBinding

class LocationActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.cancelBtn.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.locNo.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        binding.locYes.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

    }
}