package com.stupendil.myapplication

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.stupendil.myapplication.databinding.ActivityNotifScheduleBinding

class MaintenanceScheduleActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintenance_schedule)

        val btnOdo: ImageView = findViewById(R.id.iv_odometer)

        val btnGo: ImageView = findViewById(R.id.btnGonotif)
        btnGo.setOnClickListener(this)

        val btnSch: Button = findViewById(R.id.btnNextTo5)
        btnSch.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnGonotif -> {
                val intent = Intent(this@MaintenanceScheduleActivity, notifScheduleActivity::class.java)
                startActivities(arrayOf(intent))
            }
            R.id.btnNextTo5 -> {
                val intent = Intent(this@MaintenanceScheduleActivity, CreateScheduleActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}