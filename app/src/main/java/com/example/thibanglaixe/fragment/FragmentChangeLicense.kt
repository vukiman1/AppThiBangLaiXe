package com.example.thibanglaixe.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thibanglaixe.R
import com.example.thibanglaixe.activity.MainActivity
import com.example.thibanglaixe.databinding.FragmentChangeLicenseBinding


class FragmentChangeLicense: Fragment() {
    private lateinit var binding: FragmentChangeLicenseBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeLicenseBinding.inflate(inflater, container, false)
            val view = binding.root

        binding.toolbarBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
        val sharedPref = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        if(sharedPref.getBoolean("isA1", true)){
            binding.imageCheckA1.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imageCheckA2.setImageResource(0)
        } else {
            binding.imageCheckA2.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imageCheckA1.setImageResource(0)
        }
        actionCheckLicense()
        return view
    }

    private fun actionCheckLicense(){
        val sharedPref = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        binding.cardA1.setOnClickListener {
            editor.clear()
            binding.imageCheckA1.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imageCheckA2.setImageResource(0)
            (activity as MainActivity).onBackPressed()
            editor.putBoolean("isA1", true)
            editor.apply()
        }
        binding.cardA2.setOnClickListener {
            editor.clear()
            binding.imageCheckA2.setImageResource(R.drawable.ic_baseline_check_24)
            binding.imageCheckA1.setImageResource(0)
            (activity as MainActivity).onBackPressed()
            editor.putBoolean("isA1", false)
            editor.apply()
        }
    }

}