package com.woojun.yumyumschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.woojun.yumyumschool.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

        }
    }
}