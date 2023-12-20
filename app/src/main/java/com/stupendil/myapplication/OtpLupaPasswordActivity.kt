package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.stupendil.myapplication.databinding.ActivityLupaPasswordBinding
import com.stupendil.myapplication.databinding.ActivityOtpLupaPasswordBinding

class OtpLupaPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpLupaPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpLupaPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resendBtn.setOnClickListener{
            startActivity(Intent(this,LupaPassword2Activity::class.java))
        }

        showGIF()
    }

    private fun showGIF() {
        TODO("Not yet implemented")
    }

}