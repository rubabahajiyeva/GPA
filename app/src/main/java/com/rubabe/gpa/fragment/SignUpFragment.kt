package com.rubabe.gpa.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.signUpButton.setOnClickListener {
            if (binding.editTextUsername.text.isNotEmpty() && !binding.customEditText.text.isNullOrEmpty()) {
                findNavController().navigate(R.id.switchFromSignUpToInformationFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Enter your username and password",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.backIcon.setOnClickListener {
            findNavController().navigate(R.id.switchFromSignUpFragmentToWelcomeFragment)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        // Clear the text of EditText fields
        binding.editTextUsername.text.clear()
        binding.customEditText.text?.clear()
    }


}