package com.example.layered_jetpack_mvvm.features.startup.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.features.landingPage.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    
        val intent = Intent(this, MainActivity::class.java)
    
        runBlocking {
            delay(SPLASH_TIME_OUT)
            startActivity(intent)
            finish()
        }
    }
}
