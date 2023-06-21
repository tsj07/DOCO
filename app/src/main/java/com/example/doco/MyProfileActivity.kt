package com.example.doco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doco.databinding.ActivityMyProfileActivityBinding

class MyProfileActivity : AppCompatActivity() {

    lateinit var myProfileBinding: ActivityMyProfileActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myProfileBinding = ActivityMyProfileActivityBinding.inflate(layoutInflater)
        setContentView(myProfileBinding.root)

        myProfileBinding.llMyProfile.setOnClickListener {
            val intent = Intent(applicationContext, PersonalDetailsActivity::class.java)
            startActivity(intent)
        }

        myProfileBinding.rlCompleteKyc.setOnClickListener {
            val intent = Intent(applicationContext, KycActivity::class.java)
            startActivity(intent)
        }

    }
}