package org.techtown.tple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.techtown.tple.fragment.HomeFragment
import org.techtown.tple.fragment.PlanFragment
import org.techtown.tple.fragment.ProfileFragment
import org.techtown.tple.login.Login


class MainActivity : AppCompatActivity() {

    private val fl: ConstraintLayout by lazy{
        findViewById(R.id.main_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(true){       //로그인 안돼있으면
            val loginIntent = Intent(this, Login::class.java)
            startActivity(loginIntent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.b_b)

        supportFragmentManager.beginTransaction().add(fl.id, HomeFragment()).commit()

        bottomNavigationView.setOnItemSelectedListener { item ->
            changeFragment(
                when (item.itemId) {
                    R.id.menu_home -> {
                        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_home)
                        bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_home)
                        HomeFragment()
                    }
                    R.id.menu_plan -> {
                        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_plan)
                        bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_plan)
                        PlanFragment()
                    }

                    else -> {
                        bottomNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.color_profile)
                        bottomNavigationView.itemTextColor = ContextCompat.getColorStateList(this, R.color.color_profile)
                        ProfileFragment()
                    }
                }
            )
            true
        }
        bottomNavigationView.selectedItemId = R.id.menu_home
    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_layout, fragment)
            .commit()
    }
}