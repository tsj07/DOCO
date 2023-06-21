package com.example.doco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.doco.databinding.ActivityMainBinding
import com.example.doco.fragments.*

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        replaceFragment(MobileNumberFragment())

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        count--
        if (count > 0) {
            when (count) {
                1 -> {
                    replaceFragment(MobileNumberFragment())
                    count--
                }
                2 -> {
                    replaceFragment(OtpFragment())
                    count--
                }
                3 -> {
                    replaceFragment(NameFragment())
                    count--
                }
                4 -> {
                    replaceFragment(StoreNameFragment())
                    count--
                }
                5 -> {
                    replaceFragment(StorePincodeFragment())
                    count--
                }
            }
        } else
            super.onBackPressed()
    }

    internal fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
        count++
    }

}