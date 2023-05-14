package com.example.filemanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.filemanager.Fragments.CardFragment
import com.google.android.material.navigation.NavigationView
import com.example.filemanager.Fragments.HomeFragment
import com.example.filemanager.Fragments.InternalFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var toolbar : Toolbar
    lateinit var navView : NavigationView
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_internal -> replaceFragment(InternalFragment(), it.title.toString())
                R.id.nav_card -> replaceFragment(CardFragment(), it.title.toString())
                R.id.nav_about -> Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
            }
            true
        }

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        navView.setCheckedItem(R.id.nav_home)

    }

    private fun replaceFragment(fragment: Fragment, toString: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}



