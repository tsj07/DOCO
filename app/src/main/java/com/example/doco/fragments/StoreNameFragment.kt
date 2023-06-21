package com.example.doco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doco.MainActivity
import com.example.doco.databinding.FragmentStoreNameBinding

class StoreNameFragment : Fragment() {

    lateinit var binding: FragmentStoreNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreNameBinding.inflate(inflater, container, false)
        onButtonClick()
        return binding.root
    }

    private fun onButtonClick() {
        (activity as MainActivity).mainBinding.btnContinue.setOnClickListener {
            if (binding.etStoreName.text.toString().isNotEmpty()) {
                    (activity as MainActivity).replaceFragment(StorePincodeFragment())
                } else
                    Toast.makeText(requireActivity(), "Enter Store Name", Toast.LENGTH_SHORT).show()
        }
    }

}