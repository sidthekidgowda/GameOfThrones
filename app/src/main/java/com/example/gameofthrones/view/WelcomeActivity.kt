package com.example.gameofthrones.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gameofthrones.R
import com.example.gameofthrones.application.GameOfThronesApplication
import com.example.gameofthrones.di.subcomponents.ActivityComponent

class WelcomeActivity : AppCompatActivity() {

    lateinit var activityComponent:ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        //set up dagger component and inject
        activityComponent = (application as GameOfThronesApplication).component.activityComponent().create()
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, WelcomeFragment())
            .commit()
    }
}