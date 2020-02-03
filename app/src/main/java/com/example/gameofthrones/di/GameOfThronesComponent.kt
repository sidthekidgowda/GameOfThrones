package com.example.gameofthrones.di

import android.app.Application
import com.example.gameofthrones.di.subcomponents.ActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface GameOfThronesComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): GameOfThronesComponent
    }

    fun activityComponent(): ActivityComponent.Factory
}