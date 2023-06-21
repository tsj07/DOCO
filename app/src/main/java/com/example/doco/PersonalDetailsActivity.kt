package com.example.doco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doco.databinding.ActivityPersonalDetailsBinding

class PersonalDetailsActivity : AppCompatActivity() {

    lateinit var personalDetailsBinding: ActivityPersonalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personalDetailsBinding = ActivityPersonalDetailsBinding.inflate(layoutInflater)
        setContentView(personalDetailsBinding.root)
    }

}