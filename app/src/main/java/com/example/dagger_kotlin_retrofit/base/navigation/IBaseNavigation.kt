package com.example.dagger_kotlin_retrofit.base.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

interface IBaseNavigation {
    fun openScreen(
        @IdRes id: Int,
        bundle: Bundle? = null
    )
    fun bind(navController: NavController)
    fun unBind(navController: NavController)
}