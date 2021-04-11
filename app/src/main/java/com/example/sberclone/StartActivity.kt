package com.example.sberclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        window.statusBarColor = resources.getColor(R.color.colorBackStartScreen)
        Handler().postDelayed({
            startActivity(Intent(this, PinCodeActivity::class.java))
            finish()
        }, 1500)
    }
}