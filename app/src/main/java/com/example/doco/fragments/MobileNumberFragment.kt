package com.example.doco.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doco.MainActivity
import com.example.doco.databinding.FragmentMobileNumberBinding

class MobileNumberFragment : Fragment() {
    private lateinit var binding: FragmentMobileNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMobileNumberBinding.inflate(inflater, container, false)
        onButtonClick()
        return binding.root
    }

    private fun onButtonClick() {
        (activity as MainActivity).mainBinding.btnContinue.setOnClickListener {
            if (binding.etMobileNumber.text.toString().isNotEmpty()) {
                if (binding.etMobileNumber.text.toString().trim().length == 10) {
                    (activity as MainActivity).replaceFragment(OtpFragment())
                }
            } else
                Toast.makeText(requireActivity(), "Please Enter umber", Toast.LENGTH_SHORT).show()
        }
    }

}