package com.example.gameofthrones.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface GameOfThronesComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): GameOfThronesComponent
    }
}