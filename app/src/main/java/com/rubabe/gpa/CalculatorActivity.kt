package com.rubabe.gpa

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.rubabe.gpa.databinding.ActivityCalculatorBinding
import kotlin.math.round

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    // Result score of subjects
    private val multiples = IntArray(7)
    private var sum = 0
    private var sumOfTotalCredit = 0
    private var gpa = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
        hideAllLinearLayouts()
    }

    override fun onResume() {
        super.onResume()
        val count = resources.getStringArray(R.array.count)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, count)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        binding.autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            showLinearLayouts(position)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUpListeners() {
        binding.buttonCompute.setOnClickListener {
            if (checkEditTexts()) {
                if (checkSubjectScores()) {
                    calculateGPA()
                    showGPAResult()
                } else {
                    showToast("Subject score should not exceed 100")
                }
            } else {
                showToast("Please enter all the information")
            }
        }
    }

    private fun hideAllLinearLayouts() {
        for (i in 0..7) {
            getLinearLayout(i)?.visibility = View.GONE
        }
    }

    private fun showLinearLayouts(position: Int) {
         hideAllLinearLayouts()
        for (i in 0..position) {
            getLinearLayout(i)?.visibility = View.VISIBLE
        }
    }

    private fun getLinearLayout(index: Int): LinearLayout? {
        return when (index) {
            0 -> binding.linearLayout1
            1 -> binding.linearLayout2
            2 -> binding.linearLayout3
            3 -> binding.linearLayout4
            4 -> binding.linearLayout5
            5 -> binding.linearLayout6
            6 -> binding.linearLayout7
            else -> null
        }
    }

    private fun checkEditTexts(): Boolean {
        return binding.linearLayout1.isVisible &&
                binding.editTextNumber1.text.isNotEmpty() &&
                binding.editTextNumber2.text.isNotEmpty() &&
                binding.editTextNumber3.text.isNotEmpty() ||

                binding.linearLayout2.isVisible &&
                binding.editTextNumber4.text.isNotEmpty() &&
                binding.editTextNumber5.text.isNotEmpty() &&
                binding.editTextNumber6.text.isNotEmpty() ||

                binding.linearLayout3.isVisible &&
                binding.editTextNumber7.text.isNotEmpty() &&
                binding.editTextNumber8.text.isNotEmpty() &&
                binding.editTextNumber9.text.isNotEmpty() ||

                binding.linearLayout4.isVisible &&
                binding.editTextNumber10.text.isNotEmpty() &&
                binding.editTextNumber11.text.isNotEmpty() &&
                binding.editTextNumber12.text.isNotEmpty() ||

                binding.linearLayout5.isVisible &&
                binding.editTextNumber13.text.isNotEmpty() &&
                binding.editTextNumber14.text.isNotEmpty() &&
                binding.editTextNumber15.text.isNotEmpty() ||

                binding.linearLayout6.isVisible &&
                binding.editTextNumber16.text.isNotEmpty() &&
                binding.editTextNumber17.text.isNotEmpty() &&
                binding.editTextNumber18.text.isNotEmpty() ||

                binding.linearLayout7.isVisible &&
                binding.editTextNumber19.text.isNotEmpty() &&
                binding.editTextNumber20.text.isNotEmpty() &&
                binding.editTextNumber21.text.isNotEmpty()
    }

    private fun checkSubjectScores(): Boolean {
        return binding.linearLayout1.isVisible &&
                (binding.editTextNumber1.text.toString().toInt() <= 100) ||

                binding.linearLayout2.isVisible &&
                (binding.editTextNumber4.text.toString().toInt() <= 100) ||

                binding.linearLayout3.isVisible &&
                (binding.editTextNumber7.text.toString().toInt() <= 100) ||

                binding.linearLayout4.isVisible &&
                (binding.editTextNumber10.text.toString().toInt() <= 100) ||

                binding.linearLayout5.isVisible &&
                (binding.editTextNumber13.text.toString().toInt() <= 100) ||

                binding.linearLayout6.isVisible &&
                (binding.editTextNumber16.text.toString().toInt() <= 100) ||

                binding.linearLayout7.isVisible &&
                (binding.editTextNumber19.text.toString().toInt() <= 100)
    }

    private fun calculateGPA() {
        sum = 0
        sumOfTotalCredit = 0
        multiples.fill(0)

        binding.apply {
            if (binding.linearLayout1.isVisible) {
                multiples[0] =
                    editTextNumber1.text.toString().toInt() * editTextNumber2.text.toString()
                        .toInt()
                sum += multiples[0]
                sumOfTotalCredit += editTextNumber3.text.toString().toInt()
            }

            if (binding.linearLayout2.isVisible) {
                multiples[1] =
                    editTextNumber4.text.toString().toInt() * editTextNumber5.text.toString()
                        .toInt()
                sum += multiples[1]
                sumOfTotalCredit += editTextNumber6.text.toString().toInt()
            }

            if (binding.linearLayout3.isVisible) {
                multiples[2] =
                    editTextNumber7.text.toString().toInt() * editTextNumber8.text.toString()
                        .toInt()
                sum += multiples[2]
                sumOfTotalCredit += editTextNumber9.text.toString().toInt()
            }

            if (binding.linearLayout4.isVisible) {
                multiples[3] =
                    editTextNumber10.text.toString().toInt() * editTextNumber11.text.toString()
                        .toInt()
                sum += multiples[3]
                sumOfTotalCredit += editTextNumber12.text.toString().toInt()
            }

            if (binding.linearLayout5.isVisible) {
                multiples[4] =
                    editTextNumber13.text.toString().toInt() * editTextNumber14.text.toString()
                        .toInt()
                sum += multiples[4]
                sumOfTotalCredit += editTextNumber15.text.toString().toInt()
            }

            if (binding.linearLayout6.isVisible) {
                multiples[5] =
                    editTextNumber16.text.toString().toInt() * editTextNumber17.text.toString()
                        .toInt()
                sum += multiples[5]
                sumOfTotalCredit += editTextNumber18.text.toString().toInt()
            }

            if (binding.linearLayout7.isVisible) {
                multiples[6] =
                    editTextNumber19.text.toString().toInt() * editTextNumber20.text.toString()
                        .toInt()
                sum += multiples[6]
                sumOfTotalCredit += editTextNumber21.text.toString().toInt()
            }
            // Add calculations for other linear layouts

            gpa = sum.toDouble() / sumOfTotalCredit.toDouble()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showGPAResult() {
        val gpaRounded = round(gpa).toInt()
        binding.textView29.text = when (gpaRounded) {
            in 51..69 -> "$gpaRounded -> Well Result"
            in 70..89 -> "$gpaRounded -> Excellent Result"
            in 90..100 -> "$gpaRounded -> Amazing Result"
            else -> "$gpaRounded -> Fail"
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}
