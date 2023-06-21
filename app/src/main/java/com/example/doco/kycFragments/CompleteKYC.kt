package com.example.doco.kycFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doco.KycActivity
import com.example.doco.databinding.FragmentCompleteKycBinding

class CompleteKYC : Fragment() {

    lateinit var completeKycBinding: FragmentCompleteKycBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        completeKycBinding = FragmentCompleteKycBinding.inflate(inflater, container, false)
        completeKycBinding.rlUdhyamAadhaar.setOnClickListener {
            (activity as KycActivity).changeFragment(UploadAadhaar())
        }

        return completeKycBinding.root
    }

}