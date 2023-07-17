package com.rubabe.gpa.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubabe.gpa.R
import com.rubabe.gpa.databinding.FragmentStorageBinding

class StorageFragment : Fragment() {


    private lateinit var binding: FragmentStorageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("CalculatorPrefs", Context.MODE_PRIVATE)
        val gpaResult = sharedPreferences.getString("gpaResult", "")

       
    }

}