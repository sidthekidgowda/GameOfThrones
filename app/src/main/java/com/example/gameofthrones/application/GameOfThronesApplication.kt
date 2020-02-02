package com.example.gameofthrones.application

import android.app.Application
import com.example.gameofthrones.di.DaggerGameOfThronesComponent
import com.example.gameofthrones.di.GameOfThronesComponent

class GameOfThronesApplication : Application() {

    val component: GameOfThronesComponent by lazy {
        DaggerGameOfThronesComponent.factory().create(this)
    }
}