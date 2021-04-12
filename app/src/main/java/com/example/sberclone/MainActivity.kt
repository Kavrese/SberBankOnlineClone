package com.example.sberclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )


    }

    fun clickSelects(v: View){
        for (i in arrayListOf<TextView>(select1, select2, select3)) {
            i.setTextColor(getColor(R.color.colorHint2))
        }
        (v as TextView).setTextColor(getColor(R.color.colorText1))
    }
}