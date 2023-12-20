package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Angin1Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angin1)

        val backBtn: ImageView = findViewById(R.id.backButton)
        backBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.backButton -> {
                val intent = Intent(this@Angin1Activity, Article1Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}