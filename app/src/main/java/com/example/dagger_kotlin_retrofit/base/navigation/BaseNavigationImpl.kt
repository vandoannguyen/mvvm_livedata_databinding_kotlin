package com.example.dagger_kotlin_retrofit.base.navigation

import android.os.Bundle
import androidx.navigation.NavController

class BaseNavigationImpl : IBaseNavigation {
    var navigationController: NavController? = null
    override fun openScreen(id: Int, bundle: Bundle?) {
        navigationController?.navigate(id, bundle)
    }

    override fun bind(navController: NavController) {
        TODO("Not yet implemented")
    }

    override fun unBind(navController: NavController) {
        TODO("Not yet implemented")
    }
}