package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stupendil.myapplication.databinding.ActivityRescheduleBinding

class RescheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRescheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRescheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReschedule.setOnClickListener{
            startActivity(Intent(this@RescheduleActivity, RescheduleSuccesActivity::class.java))
        }

        binding.btnBack.setOnClickListener{
            startActivity(Intent(this@RescheduleActivity, notifScheduleActivity::class.java))
        }

    }
}