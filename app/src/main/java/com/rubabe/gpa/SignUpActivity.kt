package com.rubabe.gpa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rubabe.gpa.databinding.ActivitySignUpBinding
import com.rubabe.gpa.databinding.ActivityWelcomeBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    /*    binding.backIcon.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
        binding.signUpButton.setOnClickListener {
            if (binding.editTextUsername.text.isNotEmpty() && !binding.customEditText.text.isNullOrEmpty()) {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter your username and password", Toast.LENGTH_LONG).show()
            }
        }*/

    }

    override fun onResume() {
        super.onResume()
        // Clear the text of EditText fields
        binding.editTextUsername.text.clear()
        binding.customEditText.text?.clear()
    }

}
