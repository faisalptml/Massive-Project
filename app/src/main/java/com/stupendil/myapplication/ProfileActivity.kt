package com.stupendil.myapplication

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.stupendil.myapplication.databinding.ActivityLogOutBinding
import com.stupendil.myapplication.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)

        //  Auth
        auth = FirebaseAuth.getInstance()


        binding.btnBack.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        val editBtn: Button = findViewById(R.id.btnEdit)
        editBtn.setOnClickListener(this)

        val allComun: TextView = findViewById(R.id.txtView)
        allComun.setOnClickListener(this)

        val toKomun: RelativeLayout = findViewById(R.id.cardBengkel)
        toKomun.setOnClickListener(this)

        val notifBtn: ImageView = findViewById(R.id.notifBtn)

        notifBtn.setOnClickListener {
            val v: View = layoutInflater.inflate(R.layout.activity_setting_notif, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(v)
            dialog.show()
        }

        val btnNotif: ImageView = findViewById(R.id.btn_notif)
        btnNotif.setOnClickListener(this)

        val btnlogOut: ImageView = findViewById(R.id.outBtn)

        btnlogOut.setOnClickListener{
            val message : String? = "You want to LogOut?"
            showCustomDialogBox(message)
        }

        val btnLoc: ImageView = findViewById(R.id.btnLocation)

        btnLoc.setOnClickListener{
            val view: View = layoutInflater.inflate(R.layout.activity_location, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        val btnLang: ImageView = findViewById(R.id.imgBtnLang)

        btnLang.setOnClickListener{
            val view: View = layoutInflater.inflate(R.layout.activity_lenguage, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnEdit -> {
                val intent = Intent(this@ProfileActivity,EditProfileActivity::class.java)
                startActivities(arrayOf(intent))
            }
            R.id.txtView -> {
                val intent = Intent(this@ProfileActivity, DiscussFragment::class.java)
                startActivities(arrayOf(intent))
            }
            R.id.cardBengkel -> {
                val intent = Intent(this@ProfileActivity, ComunityDiscussActivity::class.java)
                startActivities(arrayOf(intent))
            }
            R.id.notifBtn -> {
                val intent = Intent(this@ProfileActivity, SettingNotifActivity::class.java)
                startActivities(arrayOf(intent))
            }
            R.id.btn_notif -> {
                val intent = Intent(this@ProfileActivity, notifScheduleActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_log_out)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tvLogOut)
        val btnYa : Button = dialog.findViewById(R.id.logOutBtn)
        val btnNo : Button = dialog.findViewById(R.id.btnCancel)

        tvMessage.text = message

        btnYa.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivities(arrayOf(intent))
            Toast.makeText(this, "LogOut Success", Toast.LENGTH_LONG).show()
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}