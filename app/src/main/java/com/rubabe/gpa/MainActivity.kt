package com.rubabe.gpa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rubabe.gpa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.tVNext.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
        setContentView(binding.root)
    }
}