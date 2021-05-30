package com.example.dagger_kotlin_retrofit.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.dagger_kotlin_retrofit.R
import com.example.dagger_kotlin_retrofit.base.BaseActivity
import com.example.dagger_kotlin_retrofit.databinding.ActivityMainBinding
import com.example.dagger_kotlin_retrofit.di.component.ActivityComponent

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>()
    {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showRateDialog.observe(this, Observer {
            kotlin.run {
//                RatingDialog(this@MainActivity).showDialog();
            }
        })
    }

    override fun setContentLayout(): Int {
        return R.layout.activity_main;
    }

    override fun performDependencyInjection(activityComponent: ActivityComponent) {
        activityComponent.inject(this@MainActivity);
    }

//    override fun onSubmit(rating: Float) {
//        if (rating >= 3) {
//            var intent = Intent(Intent.ACTION_VIEW);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setData(Uri.parse("market://details?id=" + packageName));
//            startActivity(intent);
//        }
//    }
//
//    override fun onDismiss() {
//    }
//
//    override fun onRatingChanged(rating: Float) {
//    }
}