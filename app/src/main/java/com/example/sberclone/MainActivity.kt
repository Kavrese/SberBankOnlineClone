package com.example.sberclone

import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
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

        val clickToLin = View.OnClickListener{
            if (it.layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT){
                showFull(it)
            }else{
                hideFull(it)
            }
        }

        for (i in arrayListOf(cards_lin, investor_lin, strah_lin, val_lin, vklads_lin, target_lin, security_lin, credits_lin)) {
            i.setOnClickListener(clickToLin)
            (i as ViewGroup).layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        }
    }

    fun clickSelects(v: View){
        for (i in arrayListOf<TextView>(select1, select2, select3)) {
            i.setTextColor(getColor(R.color.colorHint2))
        }
        (v as TextView).setTextColor(getColor(R.color.colorText1))
    }

    private fun showFull(view: View){
        val params =  view.layoutParams
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        view.layoutParams = params
    }

    private fun hideFull(view: View){
        val params =  view.layoutParams
        params.height = resources.getDimension(R.dimen.numdp).toInt()
        view.layoutParams = params
    }
}