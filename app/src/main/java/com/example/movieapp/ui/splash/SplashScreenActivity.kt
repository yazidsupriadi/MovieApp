package com.example.movieapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.movieapp.R
import com.example.movieapp.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val iv_splash: ImageView = findViewById(R.id.iv_splash_screen)
        iv_splash.alpha = 0f
        iv_splash.animate().setDuration(1500).alpha(1f).withEndAction(){
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}