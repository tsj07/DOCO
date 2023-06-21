package com.example.doco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doco.MainActivity
import com.example.doco.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameBinding.inflate(inflater, container, false)
        onButtonClick()
        return binding.root
    }

    private fun onButtonClick() {
        (activity as MainActivity).mainBinding.btnContinue.setOnClickListener {
            if (binding.etName.text.toString().isNotEmpty()) {
                (activity as MainActivity).replaceFragment(StoreNameFragment())
            } else
                Toast.makeText(requireActivity(), "Enter Full Name", Toast.LENGTH_SHORT).show()
        }
    }

}