package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    
    private var counter = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val counterText: TextView = findViewById(R.id.counterText)
        val btnIncrement: Button = findViewById(R.id.btnIncrement)
        val btnDecrement: Button = findViewById(R.id.btnDecrement)
        val fabReset: FloatingActionButton = findViewById(R.id.fabReset)
        
        btnIncrement.setOnClickListener {
            counter++
            updateCounter(counterText)
        }
        
        btnDecrement.setOnClickListener {
            counter--
            updateCounter(counterText)
        }
        
        fabReset.setOnClickListener {
            counter = 0
            updateCounter(counterText)
        }
    }
    
    private fun updateCounter(textView: TextView) {
        textView.text = counter.toString()
        textView.setTextColor(
            when {
                counter > 0 -> getColor(R.color.positive)
                counter < 0 -> getColor(R.color.negative)
                else -> getColor(R.color.neutral)
            }
        )
    }
}
