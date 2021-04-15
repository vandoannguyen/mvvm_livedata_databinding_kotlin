package com.example.dagger_kotlin_retrofit.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.dagger_kotlin_retrofit.R


class DialogLoading(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCanceledOnTouchOutside(false);
        setCancelable(false)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
        getWindow()?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        );
        setContentView(R.layout.dialog_loading)
    }
}