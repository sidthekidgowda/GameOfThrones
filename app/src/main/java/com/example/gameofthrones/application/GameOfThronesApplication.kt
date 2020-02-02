package com.example.gameofthrones.application

import android.app.Application
import com.example.gameofthrones.di.DaggerGOTComponent
import com.example.gameofthrones.di.GameOfThronesComponent

class GameOfThronesApplication : Application() {

    val component: GameOfThronesComponent by lazy {
        DaggerGOTComponent.factory().create(this)
    }
}