package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.stupendil.myapplication.databinding.ActivityCreateScheduleBinding
import com.stupendil.myapplication.databinding.ActivityLoginBinding

class CreateScheduleActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCreateScheduleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCreateScheduleBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.btnCreate.setOnClickListener{
            startActivity(Intent(this, LoadingDetailActivity::class.java))
        }

        mBinding.cancelBtn.setOnClickListener{
            startActivity(Intent(this, MaintenanceScheduleActivity::class.java))
        }

    }
}