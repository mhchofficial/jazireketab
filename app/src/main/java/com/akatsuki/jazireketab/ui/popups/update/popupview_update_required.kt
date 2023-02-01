package com.akatsuki.jazireketab.ui.popups.update

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R


class popupview_update_required(ctx: Context, val activity: FragmentActivity): AlertDialog(ctx) {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_view)
        this.window?.attributes?.windowAnimations = R.style.DialogAnimation
        this.window?.setBackgroundDrawableResource(android.R.color.transparent)
        this.window?.setGravity(Gravity.CENTER)
        this.setCancelable(false)
        this.findViewById<Button>(R.id.update_btn).setOnClickListener{
            this.dismiss()
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }

    }

}