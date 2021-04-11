package com.example.sberclone

import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.hardware.fingerprint.FingerprintManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_pin_code.*
import java.lang.Exception
import java.security.KeyStore

class PinCodeActivity : AppCompatActivity() {
    private var now_point = 0
    lateinit var list_points: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_code)
        window.statusBarColor = resources.getColor(R.color.colorToolBarBackPinCodeScreen)
        list_points = arrayListOf<ImageView>(point1, point2, point3, point4, point5)
        initKeyboards()
    }

    private fun initKeyboards(){
        val click_next_point = View.OnClickListener{
            nextPoint()
            checkPoints()
        }
        for (i in arrayListOf<TextView>(one, two, three, foor, five, six, seven, eight, nine, zero)){
            i.setOnClickListener(click_next_point)
        }
        back_del.setOnClickListener {previewPoint()}

        finger_print.setOnClickListener {
            if (checkUseFingerprint()){
                //ПОТОМ
            }
        }
    }

    private fun nextPoint(){
        vibro()
        if (now_point < 5){
            list_points[now_point].setColorFilter(getColor(R.color.colorGreen))
            now_point ++
        }
    }

    private fun checkPoints(){
        if (now_point == 5){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun previewPoint(){
        vibro()
        if (now_point > 0){
            now_point --
            list_points[now_point].setColorFilter(getColor(R.color.colorHint1))
        }
    }

    private fun vibro(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        }
    }

    private fun checkUseFingerprint(): Boolean{
        val manager_finger = getSystemService(FINGERPRINT_SERVICE) as FingerprintManager
        val manager_keys = getSystemService(KEYGUARD_SERVICE) as KeyguardManager
        var check_key_store = false
        try {
            val keyStore = KeyStore.getInstance("KEY_STORE")
            keyStore.load(null)
            check_key_store = true
        }catch (e: Exception){
            e.printStackTrace()
        }
        return manager_finger.isHardwareDetected && manager_finger.hasEnrolledFingerprints() && manager_keys.isKeyguardSecure && check_key_store
    }
}