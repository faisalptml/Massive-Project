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

class EditProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val btnSave: Button = findViewById(R.id.btnSaveChanges)

        btnSave.setOnClickListener {
            val message : String? = "Do you want to save the changes?"
            showCustomDialogBox(message)
        }

        val btnBack: ImageView = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)

    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_pop_up_edit_profile)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes : Button = dialog.findViewById(R.id.btnYes)
        val btnNo : Button = dialog.findViewById(R.id.btnDiscard)

        tvMessage.text = message

        btnYes.setOnClickListener{
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivities(arrayOf(intent))
            Toast.makeText(this, "Edit Success", Toast.LENGTH_LONG).show()
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_back -> {
                val intent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}