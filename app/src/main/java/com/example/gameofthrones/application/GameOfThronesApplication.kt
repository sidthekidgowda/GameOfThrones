package com.example.gameofthrones.application

import androidx.multidex.MultiDexApplication
import com.example.gameofthrones.di.DaggerGameOfThronesComponent
import com.example.gameofthrones.di.GameOfThronesComponent

class GameOfThronesApplication : MultiDexApplication() {

    val component: GameOfThronesComponent by lazy {
        DaggerGameOfThronesComponent.factory().create(this)
    }
}