package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stupendil.myapplication.databinding.ActivityCreateUsernameBinding

class CreateUsernameActivity : AppCompatActivity(), View.OnFocusChangeListener,
    View.OnClickListener {

    private lateinit var mBinding: ActivityCreateUsernameBinding
    private lateinit var etUname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCreateUsernameBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.hintUN.onFocusChangeListener = this

        etUname = findViewById(R.id.hintUN)

        val bundle = intent.extras
        if (bundle != null){
            etUname.setText(bundle.getString("Usernamee"))

        }

        val btnBack: Button = findViewById(R.id.btnContinue)
        btnBack.setOnClickListener(this)

        showGIF()

    }

    private fun showGIF() {
        val imageView: ImageView = findViewById(R.id.iv_createUN)
        Glide.with(this).load(R.drawable.createunpict).into(imageView)
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnContinue -> {
                val intent = Intent(this@CreateUsernameActivity, LoadingActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}