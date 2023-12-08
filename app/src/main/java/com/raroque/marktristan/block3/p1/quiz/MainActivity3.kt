package com.raroque.marktristan.block3.p1.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        scoreTextView = findViewById(R.id.score)

        val score = intent.getIntExtra("score", 0)
        scoreTextView.text = "$score"
    }
}