package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LastMaintActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_maint)

        val btnNext: Button = findViewById(R.id.btnNextTo5)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnNextTo5 -> {
                val intent = Intent(this@LastMaintActivity, Spesifikasi8Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}