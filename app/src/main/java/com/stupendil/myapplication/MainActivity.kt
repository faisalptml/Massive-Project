package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import com.stupendil.myapplication.databinding.ActivityLoginBinding
import com.stupendil.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val homeFragment = HomeFragment()
        val discussFragment = DiscussFragment()
        val scheduleFragment = ScheduleFragment()
        val historyFragment = HistoryFragmen()
        val chatBotFragment = ChatBotFragmen()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        binding.linearlyt.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        binding.tiresPict.setOnClickListener{
            startActivity(Intent(this,Article1Activity::class.java))
        }

        replaceFragment(homeFragment)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> replaceFragment(homeFragment)
                R.id.discussFragment2 -> replaceFragment(discussFragment)
                R.id.scheduleFragment -> replaceFragment(scheduleFragment)
                R.id.historyFragment -> replaceFragment(historyFragment)
                R.id.chatBotFragment -> replaceFragment(chatBotFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}