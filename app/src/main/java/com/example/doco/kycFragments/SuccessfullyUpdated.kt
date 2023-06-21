package com.example.doco.kycFragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doco.PersonalDetailsActivity
import com.example.doco.R

class SuccessfullyUpdated : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_successfully_updated, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(requireContext(), PersonalDetailsActivity::class.java)
            startActivity(intent)
        }, 1200)

        return view
    }
}