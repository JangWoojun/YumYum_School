package com.woojun.yumyumschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.woojun.yumyumschool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val navController = findNavController(R.id.nav_host_fragment)

            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        navController.navigate(R.id.home)
                        true
                    }
                    R.id.foodList -> {
                        navController.navigate(R.id.foodList)
                        true
                    }
                    else -> {
                        false
                    }
                }
            }

            fab.setOnClickListener {
                navController.navigate(R.id.bestFood)
            }

        }
    }
}