package com.stupendil.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.stupendil.myapplication.databinding.ActivityLogOutBinding

class LogOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogOutBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogOutBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        binding.btnCancel.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        binding.iconCancel.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

    }

    fun logoutUser(view: View) {
        auth.signOut()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
