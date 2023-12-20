package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class OtpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        val btnNext: Button = findViewById(R.id.registrasiBtn)
        btnNext.setOnClickListener(this)

        val btnOtp: Button = findViewById(R.id.OtpBtn)
        btnOtp.setOnClickListener(this)

        val btnBack: ImageView = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)

        showGIF()
    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_otp)
        Glide.with(this).load(R.drawable.otppict).into(imageView)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.registrasiBtn -> {
                val intent = Intent(this@OtpActivity, CreateUsernameActivity::class.java)
                startActivities(arrayOf(intent))
            }

            R.id.btn_back -> {
                val intent = Intent(this@OtpActivity, RegistActivity::class.java)
                startActivities(arrayOf(intent))
            }

            R.id.OtpBtn -> {
                val intent = Intent(this@OtpActivity, LupaPassword2Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}