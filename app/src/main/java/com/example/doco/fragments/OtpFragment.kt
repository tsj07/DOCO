package com.example.doco.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doco.MainActivity
import com.example.doco.databinding.FragmentOtpBinding

class OtpFragment : Fragment() {

    private lateinit var binding: FragmentOtpBinding
    private lateinit var otpNumber: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOtpBinding.inflate(inflater, container, false)

        otpTextFocus()
        continueButtonClick()

        return binding.root
    }

    private fun continueButtonClick() {
        (activity as MainActivity).mainBinding.btnContinue.setOnClickListener {
            otpNumber = binding.et1.text.toString().trim() +
                    binding.et2.text.toString().trim() +
                    binding.et3.text.toString().trim() +
                    binding.et4.text.toString().trim() +
                    binding.et5.text.toString().trim() +
                    binding.et6.text.toString().trim()

            if (otpNumber.length == 6) {
                (activity as MainActivity).replaceFragment(NameFragment())
            } else
                Toast.makeText(
                    requireActivity(), "Enter correct otp", Toast.LENGTH_SHORT
                ).show()
        }
    }

    private fun otpTextFocus() {
        binding.et1.addTextChangedListener(textWatcher1)
        binding.et2.addTextChangedListener(textWatcher2)
        binding.et3.addTextChangedListener(textWatcher3)
        binding.et4.addTextChangedListener(textWatcher4)
        binding.et5.addTextChangedListener(textWatcher5)
        binding.et6.addTextChangedListener(textWatcher6)
    }

    private val textWatcher1 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().trim().isNotEmpty())
                binding.et2.requestFocus()
        }
    }

    private val textWatcher2 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().trim().isNotEmpty())
                binding.et3.requestFocus()
        }
    }

    private val textWatcher3 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().trim().isNotEmpty())
                binding.et4.requestFocus()
        }
    }

    private val textWatcher4 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().trim().isNotEmpty())
                binding.et5.requestFocus()
        }
    }

    private val textWatcher5 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().trim().isNotEmpty())
                binding.et6.requestFocus()
        }
    }

    private val textWatcher6 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString().length == 1) {
                (activity as MainActivity).mainBinding.btnContinue.requestFocus()
            }
        }
    }

}