package com.stupendil.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Article1Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article1)

        val cardBtn: CardView = findViewById(R.id.cardView)
        cardBtn.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.cardView -> {
                val intent = Intent(this@Article1Activity, Angin1Activity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}