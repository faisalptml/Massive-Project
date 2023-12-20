package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class PopUpEditProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_edit_profile)

        val yesBtn: Button = findViewById(R.id.btnYes)
        yesBtn.setOnClickListener(this)

        showGIF()

    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.popPict)
        Glide.with(this).load(R.drawable.popup_editfotopict).into(imageView)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnYes -> {
                val intent = Intent(this@PopUpEditProfileActivity, ProfileActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}