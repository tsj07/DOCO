package com.example.doco

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.doco.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var homeBinding: ActivityHomeBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        setUpViews()

    }

    private fun setUpViews() {
        setUpDrawerLayout()
        setUpHeaderView()
    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(homeBinding.toolBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            homeBinding.drawerLayout,
            R.string.home,
            R.string.home
        )
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpHeaderView() {
        val headerView: View = homeBinding.navigationView.getHeaderView(0)
        val viewProfile = headerView.findViewById(R.id.nav_view_profile) as TextView
        viewProfile.setOnClickListener {
            homeBinding.drawerLayout.closeDrawers()
            val intent = Intent(applicationContext, MyProfileActivity::class.java)
            startActivity(intent)
        }
    }

}