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

class notifScheduleActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif_schedule)

        val btnBac: ImageView = findViewById(R.id.btn_back)
        btnBac.setOnClickListener(this)

        val popUp : TextView = findViewById(R.id.rectangleNotifSchedule1)

        popUp.setOnClickListener {
            val message : String? = "Fix the bike?"
            showCustomDialogBox(message)
        }

    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pop_up_notif2)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage: TextView = dialog.findViewById(R.id.dateInfo)
        val btnYes: Button = dialog.findViewById(R.id.btnYa)
        val btnNo: Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener {
            val intent = Intent(this, notifScheduleActivity::class.java)
            startActivities(arrayOf(intent))
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, RescheduleActivity::class.java)
            startActivities(arrayOf(intent))
        }
        dialog.show()
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_back -> {
                val intent = Intent(this@notifScheduleActivity,ProfileActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}