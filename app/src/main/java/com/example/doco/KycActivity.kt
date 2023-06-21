package com.example.doco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.doco.kycFragments.CompleteKYC
import com.example.doco.kycFragments.DeliveryAddress
import com.example.doco.kycFragments.UploadAadhaar

class KycActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kyc)
        changeFragment(DeliveryAddress())
    }

    internal fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.containerKYC, fragment)
        fragmentTransaction.commitAllowingStateLoss()
        count++
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        count--
        when (count) {
            0 -> super.onBackPressed()
            1 -> {
                changeFragment(DeliveryAddress())
                count--
            }
            2 -> {
                changeFragment(CompleteKYC())
                count--
            }
            3 -> {
                changeFragment(UploadAadhaar())
                count--
            }
        }
    }

}