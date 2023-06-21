package com.example.doco.kycFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doco.KycActivity
import com.example.doco.databinding.FragmentDeliveryAddressBinding

class DeliveryAddress : Fragment() {

    lateinit var deliveryAddressBinding: FragmentDeliveryAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        deliveryAddressBinding =  FragmentDeliveryAddressBinding.inflate(inflater, container, false)

        deliveryAddressBinding.btnNext.setOnClickListener {
            (activity as KycActivity).changeFragment(CompleteKYC())
        }

        return  deliveryAddressBinding.root
    }
}