package com.rubabe.gpa

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rubabe.gpa.databinding.ActivityCalculatorBinding
import kotlin.math.round

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    //Result score of Subject
    private var multiple1 = 0
    private var multiple2 = 0
    private var multiple3 = 0
    private var multiple4 = 0
    private var multiple5 = 0
    private var multiple6 = 0
    private var sum = 0
    private var sumOfTotalCredit = 0
    private var gpa = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    @SuppressLint("SetTextI18n")
    fun setUpListeners() {
        binding.buttonCompute.setOnClickListener {
            binding.apply {
                if (editTextNumber.text.isNotEmpty() && editTextNumber2.text.isNotEmpty() &&
                    editTextNumber3.text.isNotEmpty() && editTextNumber4.text.isNotEmpty() &&
                    editTextNumber5.text.isNotEmpty() && editTextNumber10.text.isNotEmpty() &&
                    editTextNumber11.text.isNotEmpty() && editTextNumber12.text.isNotEmpty() &&
                    editTextNumber13.text.isNotEmpty() && editTextNumber14.text.isNotEmpty() &&
                    editTextNumber15.text.isNotEmpty() && editTextNumber16.text.isNotEmpty() &&
                    editTextNumber17.text.isNotEmpty() && editTextNumber18.text.isNotEmpty() &&
                    editTextNumber19.text.isNotEmpty() && editTextNumber20.text.isNotEmpty() &&
                    editTextNumber21.text.isNotEmpty() && editTextNumber22.text.isNotEmpty()
                ) {
                    if (editTextNumber.text.toString().toInt() > 100 ||
                        editTextNumber4.text.toString().toInt() > 100 ||
                        editTextNumber11.text.toString().toInt() > 100 ||
                        editTextNumber14.text.toString().toInt() > 100 ||
                        editTextNumber17.text.toString().toInt() > 100 ||
                        editTextNumber20.text.toString().toInt() > 100
                    ) {
                        Toast.makeText(
                            applicationContext,
                            "Subject score not be more than 100",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        multiple1 =
                            editTextNumber.text.toString().toInt() * editTextNumber2.text.toString()
                                .toInt()
                        multiple2 = editTextNumber4.text.toString()
                            .toInt() * editTextNumber5.text.toString().toInt()
                        multiple3 = editTextNumber11.text.toString()
                            .toInt() * editTextNumber12.text.toString().toInt()
                        multiple4 = editTextNumber14.text.toString()
                            .toInt() * editTextNumber15.text.toString().toInt()
                        multiple5 = editTextNumber17.text.toString()
                            .toInt() * editTextNumber18.text.toString().toInt()
                        multiple6 = editTextNumber20.text.toString()
                            .toInt() * editTextNumber21.text.toString().toInt()

                        sum = multiple1 + multiple2 + multiple3 + multiple4 + multiple5 + multiple6
                        sumOfTotalCredit = editTextNumber3.text.toString()
                            .toInt() + editTextNumber10.text.toString()
                            .toInt() + editTextNumber13.text.toString()
                            .toInt() + editTextNumber16.text.toString()
                            .toInt() + editTextNumber19.text.toString()
                            .toInt() + editTextNumber22.text.toString().toInt()

                        gpa = sum.toDouble() / sumOfTotalCredit.toDouble()
                        when (val gpaRounded = round(gpa).toInt()) {
                            in 51..69 -> textView29.text = "$gpaRounded -> Well Result"
                            in 70..89 -> textView29.text = "$gpaRounded -> Excellent Result"
                            in 90..100 -> textView29.text = "$gpaRounded -> Amazing Result"

                            else -> textView29.text = "$gpaRounded -> Fail"
                        }
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Please, Write the information completely",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }
}