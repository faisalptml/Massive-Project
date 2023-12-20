package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Spesifikasi5Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spesifikasi5)

        val btnToSix: Button = findViewById(R.id.btnNextTo6)
        btnToSix.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnNextTo6 -> {
                val intent = Intent(this@Spesifikasi5Activity, Spesifikasi6Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}