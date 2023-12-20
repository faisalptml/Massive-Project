package com.stupendil.myapplication

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EditScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_schedule)

        val btnSave: Button = findViewById(R.id.btn_create)
        btnSave.setOnClickListener {
            val message : String? = "Do you want to save the changes?"
            showCustomDialogBox(message)
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pop_up_edit_schedule)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.subJudul)
        val btnYes : Button = dialog.findViewById(R.id.btnYa)
        val btnNo : Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startActivities(arrayOf(intent))
            Toast.makeText(this, "Edit Success", Toast.LENGTH_LONG).show()
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}