package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stupendil.myapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Txtedit.setOnClickListener{
            startActivity(Intent(this@DetailActivity, EditScheduleActivity::class.java))
        }

        binding.btnKembali.setOnClickListener{
            startActivity(Intent(this@DetailActivity, MainActivity::class.java))
        }

    }
}