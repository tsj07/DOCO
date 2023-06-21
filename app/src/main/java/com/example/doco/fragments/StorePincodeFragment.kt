package com.example.doco.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.doco.HomeActivity
import com.example.doco.MainActivity
import com.example.doco.databinding.FragmentStorePincodeBinding

class StorePincodeFragment : Fragment() {
    lateinit var storePincodeBinding: FragmentStorePincodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        storePincodeBinding =  FragmentStorePincodeBinding.inflate(inflater, container, false)
        onButtonClick()
        return storePincodeBinding.root
    }

    private fun onButtonClick() {
        (activity as MainActivity).mainBinding.btnContinue.setOnClickListener {
            if (storePincodeBinding.etStorePincode.text.toString().isNotEmpty()) {
                if (storePincodeBinding.etStorePincode.text.toString().trim().length == 6){
                    val intent = Intent(requireContext(), HomeActivity::class.java)
                    startActivity(intent)
                }
            } else
                Toast.makeText(requireActivity(), "Enter Store Pincode", Toast.LENGTH_SHORT).show()
        }
    }
}