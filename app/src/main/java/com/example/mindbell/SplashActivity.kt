package com.example.mindbell

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var keepOnScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Install SplashScreen API (Bawaan Android 12+)
        // Fungsi ini harus dipanggil sebelum super.onCreate()
        val splashScreen = installSplashScreen()
        
        super.onCreate(savedInstanceState)

        // 2. Mencegah Splash Screen "kedua" muncul
        // Kita biarkan SplashScreen sistem tetap tampil (KeepOnScreen) 
        // sampai timer kita selesai, lalu langsung pindah ke MainActivity.
        // Dengan cara ini, tidak akan ada transisi ke layout XML kosong.
        splashScreen.setKeepOnScreenCondition { keepOnScreen }

        Handler(Looper.getMainLooper()).postDelayed({
            keepOnScreen = false // Melepaskan Splash Screen sistem agar bisa lanjut

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
