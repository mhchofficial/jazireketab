package com.akatsuki.jazireketab.ui.activity.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.ui.popups.update.popupview_update_required

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        val runnable = Runnable { //Second Splash fragment after 1 seconds appears
            popupview_update_required(this, this).show()
        }

        handler.postDelayed(runnable, 3000)
       /* Handler().postDelayed({

        }, 2000)*/
    }
}