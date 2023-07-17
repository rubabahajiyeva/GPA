package com.rubabe.gpa.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentInformationBinding


class InformationFragment : Fragment() {
    private lateinit var binding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.tVNext.setOnClickListener {
            findNavController().navigate(R.id.switchFromInformationFragmentToCalculatorFragment)
        }
        return view
    }

}