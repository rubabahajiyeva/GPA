package com.rubabe.gpa.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentCalculatorBinding
import kotlin.math.round

class CalculatorFragment : Fragment() {
    lateinit var binding: FragmentCalculatorBinding

    // Result score of subjects
    private val multiples = IntArray(7)
    private var sum = 0
    private var sumOfTotalCredit = 0
    private var gpa = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        hideAllLinearLayouts()
    }

    override fun onResume() {
        super.onResume()
        val count = resources.getStringArray(R.array.count)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, count)
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
        val subjectScores = listOf(
            binding.editTextNumber1.text.toString().toIntOrNull(),
            binding.editTextNumber4.text.toString().toIntOrNull(),
            binding.editTextNumber7.text.toString().toIntOrNull(),
            binding.editTextNumber10.text.toString().toIntOrNull(),
            binding.editTextNumber13.text.toString().toIntOrNull(),
            binding.editTextNumber16.text.toString().toIntOrNull(),
            binding.editTextNumber19.text.toString().toIntOrNull()
        )

        val exceedsLimit = subjectScores.any { it != null && it > 100 }
        if (exceedsLimit) {
            showToast("Subject score should not exceed 100")
        }
        return !exceedsLimit
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
        binding.resultText.text = when (gpaRounded) {
            in 51..69 -> "$gpaRounded -> Well Result"
            in 70..89 -> "$gpaRounded -> Excellent Result"
            in 90..100 -> "$gpaRounded -> Amazing Result"
            else -> "$gpaRounded -> Fail"
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}