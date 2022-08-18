package com.humam.challengechapter4.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.humam.challengechapter4.activity.MainActivity
import com.humam.challengechapter4.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    var binding: ActivitySplashScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.hide()

        binding?.apply {
            Glide.with(this@SplashScreen)
                .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
                .into(ivSplashScreen1)
        }

        Handler (Looper.getMainLooper()).postDelayed({
            Intent(this, MainActivity::class.java)
                .apply {
                    startActivity(this)
                }
            finish()
        }, 3000)
    }
}