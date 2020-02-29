package com.example.gameofthrones.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.gameofthrones.R
import com.example.gameofthrones.application.GameOfThronesApplication
import com.example.gameofthrones.databinding.ActivityMainBinding
import com.example.gameofthrones.di.subcomponents.ActivityComponent

class WelcomeActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        //set up dagger component and inject
        activityComponent = (application as GameOfThronesApplication)
            .component
            .activityComponent()
            .create()

        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}
