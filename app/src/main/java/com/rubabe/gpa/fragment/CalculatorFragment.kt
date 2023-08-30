package com.rubabe.gpa.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentCalculatorBinding
import kotlin.math.round

class CalculatorFragment : Fragment() {
    lateinit var binding: FragmentCalculatorBinding

    private var gpa = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideAllLinearLayouts()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.buttonCompute.setOnClickListener {
            if (checkAllEditTextFields()) {
                calculateGPA()
            }

        }
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


    private fun hideAllLinearLayouts(): Boolean {
        for (i in 0..7) {
            getLinearLayout(i)?.visibility = View.GONE
        }
        return true
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

    fun checkEditText(linearLayout: LinearLayout, editTextIds: List<Int>): Boolean {
        if (linearLayout.isVisible) {
            for (editTextId in editTextIds) {
                val editText = linearLayout.findViewById<EditText>(editTextId)
                if (editText.text.toString().isEmpty()) {
                    showToast("Please enter all the information")
                    return false
                }
            }
            return true
        }

        else{
            binding.resultText.text = ""
            return false
        }
    }

    fun checkAllEditTextFields(): Boolean {
        val layout1 = binding.linearLayout1
        val layout2 = binding.linearLayout2
        val layout3 = binding.linearLayout3
        val layout4 = binding.linearLayout4
        val layout5 = binding.linearLayout5
        val layout6 = binding.linearLayout6
        val layout7 = binding.linearLayout7

        val editTextIdsLayout1 =
            listOf(R.id.editTextNumber1, R.id.editTextNumber2, R.id.editTextNumber3)
        val editTextIdsLayout2 =
            listOf(R.id.editTextNumber4, R.id.editTextNumber5, R.id.editTextNumber6)
        val editTextIdsLayout3 =
            listOf(R.id.editTextNumber7, R.id.editTextNumber8, R.id.editTextNumber9)
        val editTextIdsLayout4 =
            listOf(R.id.editTextNumber10, R.id.editTextNumber11, R.id.editTextNumber12)
        val editTextIdsLayout5 =
            listOf(R.id.editTextNumber13, R.id.editTextNumber14, R.id.editTextNumber15)
        val editTextIdsLayout6 =
            listOf(R.id.editTextNumber16, R.id.editTextNumber17, R.id.editTextNumber18)
        val editTextIdsLayout7 =
            listOf(R.id.editTextNumber19, R.id.editTextNumber20, R.id.editTextNumber21)



         if (layout1.isVisible && layout2.isVisible && layout3.isVisible && layout4.isVisible && layout5.isVisible && layout6.isVisible && layout7.isVisible) {
            checkEditText(layout1, editTextIdsLayout1) && checkEditText(
                layout2,
                editTextIdsLayout2
            )
                    && checkEditText(layout3, editTextIdsLayout3) && checkEditText(
                layout4,
                editTextIdsLayout4
            )
                    && checkEditText(layout5, editTextIdsLayout5) && checkEditText(
                layout6,
                editTextIdsLayout6
            )
                    && checkEditText(layout7, editTextIdsLayout7)
        }

         else if (layout1.isVisible && layout2.isVisible && layout3.isVisible && layout4.isVisible && layout5.isVisible && layout6.isVisible) {
             checkEditText(layout1, editTextIdsLayout1) && checkEditText(
                 layout2,
                 editTextIdsLayout2
             )
                     && checkEditText(layout3, editTextIdsLayout3) && checkEditText(
                 layout4,
                 editTextIdsLayout4
             )
                     && checkEditText(layout5, editTextIdsLayout5) && checkEditText(
                 layout6,
                 editTextIdsLayout6
             )
         }
         else if (layout1.isVisible && layout2.isVisible && layout3.isVisible && layout4.isVisible && layout5.isVisible) {
             checkEditText(layout1, editTextIdsLayout1) && checkEditText(
                 layout2,
                 editTextIdsLayout2
             )
                     && checkEditText(layout3, editTextIdsLayout3) && checkEditText(
                 layout4,
                 editTextIdsLayout4
             )
                     && checkEditText(layout5, editTextIdsLayout5)
         }

         else if (layout1.isVisible && layout2.isVisible) {
            checkEditText(layout1, editTextIdsLayout1) && checkEditText(layout2, editTextIdsLayout2)
        } else if (layout1.isVisible && layout2.isVisible && layout3.isVisible) {
            checkEditText(layout1, editTextIdsLayout1) && checkEditText(layout2, editTextIdsLayout2)
                    && checkEditText(layout3, editTextIdsLayout3)
        } else if (layout1.isVisible && layout2.isVisible && layout3.isVisible && layout4.isVisible) {
            checkEditText(layout1, editTextIdsLayout1) && checkEditText(layout2, editTextIdsLayout2)
                    && checkEditText(layout3, editTextIdsLayout3) && checkEditText(
                layout4,
                editTextIdsLayout4
            )
        }

       else if (layout1.isVisible) {
            checkEditText(layout1, editTextIdsLayout1)
        }
        return true
    }


    private fun calculateGPA() {
        var total = 0.0
        val editText1Value = binding.editTextNumber1.text.toString().toIntOrNull() ?: 0
        val editText2Value = binding.editTextNumber2.text.toString().toIntOrNull() ?: 0
        val editText3Value = binding.editTextNumber3.text.toString().toIntOrNull() ?: 1

        val editText4Value = binding.editTextNumber4.text.toString().toIntOrNull() ?: 0
        val editText5Value = binding.editTextNumber5.text.toString().toIntOrNull() ?: 0
        val editText6Value = binding.editTextNumber6.text.toString().toIntOrNull() ?: 1


        val editText7Value = binding.editTextNumber7.text.toString().toIntOrNull() ?: 0
        val editText8Value = binding.editTextNumber8.text.toString().toIntOrNull() ?: 0
        val editText9Value = binding.editTextNumber9.text.toString().toIntOrNull() ?: 1


        val editText10Value = binding.editTextNumber10.text.toString().toIntOrNull() ?: 0
        val editText11Value = binding.editTextNumber11.text.toString().toIntOrNull() ?: 0
        val editText12Value = binding.editTextNumber12.text.toString().toIntOrNull() ?: 1


        val editText13Value = binding.editTextNumber13.text.toString().toIntOrNull() ?: 0
        val editText14Value = binding.editTextNumber14.text.toString().toIntOrNull() ?: 0
        val editText15Value = binding.editTextNumber15.text.toString().toIntOrNull() ?: 1


        val editText16Value = binding.editTextNumber16.text.toString().toIntOrNull() ?: 0
        val editText17Value = binding.editTextNumber17.text.toString().toIntOrNull() ?: 0
        val editText18Value = binding.editTextNumber18.text.toString().toIntOrNull() ?: 1

        val editText19Value = binding.editTextNumber19.text.toString().toIntOrNull() ?: 0
        val editText20Value = binding.editTextNumber20.text.toString().toIntOrNull() ?: 0
        val editText21Value = binding.editTextNumber21.text.toString().toIntOrNull() ?: 1


        if (binding.linearLayout2.isVisible && binding.linearLayout3.isVisible && binding.linearLayout4.isVisible && binding.linearLayout5.isVisible && binding.linearLayout6.isVisible && binding.linearLayout7.isVisible && editText5Value != 0 && editText8Value != 0 && editText11Value != 0 && editText14Value != 0 && editText17Value != 0 && editText20Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value) + (editText7Value * editText8Value) + (editText10Value * editText11Value) + (editText13Value * editText14Value) + (editText16Value * editText17Value) + (editText19Value * editText20Value)) / (editText3Value + editText6Value + editText9Value + editText12Value + editText15Value + editText18Value + editText21Value)).toDouble()
        } else if (binding.linearLayout2.isVisible && binding.linearLayout3.isVisible && binding.linearLayout4.isVisible && binding.linearLayout5.isVisible && binding.linearLayout6.isVisible && editText5Value != 0 && editText8Value != 0 && editText11Value != 0 && editText14Value != 0 && editText17Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value) + (editText7Value * editText8Value) + (editText10Value * editText11Value) + (editText13Value * editText14Value) + (editText16Value * editText17Value)) / (editText3Value + editText6Value + editText9Value + editText12Value + editText15Value + editText18Value)).toDouble()
        } else if (binding.linearLayout2.isVisible && binding.linearLayout3.isVisible && binding.linearLayout4.isVisible && binding.linearLayout5.isVisible && editText5Value != 0 && editText8Value != 0 && editText11Value != 0 && editText14Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value) + (editText7Value * editText8Value) + (editText10Value * editText11Value) + (editText13Value * editText14Value)) / (editText3Value + editText6Value + editText9Value + editText12Value + editText15Value)).toDouble()
        } else if (binding.linearLayout2.isVisible && binding.linearLayout3.isVisible && binding.linearLayout4.isVisible && editText5Value != 0 && editText8Value != 0 && editText11Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value) + (editText7Value * editText8Value) + (editText10Value * editText11Value)) / (editText3Value + editText6Value + editText9Value + editText12Value)).toDouble()
        } else if (binding.linearLayout2.isVisible && binding.linearLayout3.isVisible && editText5Value != 0 && editText8Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value) + (editText7Value * editText8Value)) / (editText3Value + editText6Value + editText9Value)).toDouble()
        } else if (binding.linearLayout2.isVisible && editText5Value != 0) {
            total = (((editText1Value * editText2Value) +
                    (editText4Value * editText5Value)) / (editText3Value + editText6Value)).toDouble()
            // Add similar terms for other layouts if needed
        } else if (binding.linearLayout1.isVisible && editText2Value != 0) {
            total = ((editText1Value * editText2Value) / editText3Value).toDouble()
            // Add similar terms for other layouts if needed
        }else{
            binding.resultText.text = ""
        }

        if (editText1Value <= 100 && editText4Value <= 100 && editText7Value <= 100 && editText10Value <= 100 && editText13Value <= 100 && editText16Value <= 100 && editText19Value <= 100) {
            if (editText2Value <= editText3Value && editText5Value <= editText6Value && editText8Value <= editText9Value && editText11Value <= editText12Value && editText14Value <= editText15Value && editText17Value <= editText18Value && editText20Value <= editText21Value) {
                gpa = total
                showGPAResult()
            }
            else {
                showToast("k* must be less than or equal to k")
            }
        }  else {
            showToast("Subject score should not exceed 100")
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showGPAResult() {
        println("total3: $gpa")
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