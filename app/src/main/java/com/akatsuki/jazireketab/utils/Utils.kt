package com.akatsuki.jazireketab.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


fun Context.ToastIcon(msg: String, isLong: Boolean){
    val inflater = LayoutInflater.from(this)
    val layout: View = inflater.inflate(com.akatsuki.jazireketab.R.layout.toast_layout, null)
    val image: ImageView = layout.findViewById<View>(com.akatsuki.jazireketab.R.id.toast_image) as ImageView
    image.setImageResource(com.akatsuki.jazireketab.R.drawable.logo_green)
    val textV = layout.findViewById<View>(com.akatsuki.jazireketab.R.id.toast_text) as TextView
    textV.setText(msg)
    val toast = Toast(this)
    toast.setGravity(Gravity.BOTTOM, 0, 0)
    toast.duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    toast.setView(layout)
    toast.show()

}