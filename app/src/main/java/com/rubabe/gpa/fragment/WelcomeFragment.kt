package com.rubabe.gpa.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.asGuestButton.setOnClickListener {
            findNavController().navigate(R.id.switchFromWelcomeFragmentToInformationFragment)
        }

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.switchFromWelcomeFragmentToSignUpFragment)
        }

        binding.switchMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        return view
    }

}