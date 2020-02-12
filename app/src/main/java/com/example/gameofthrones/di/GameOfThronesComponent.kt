package com.example.gameofthrones.di

import android.app.Application
import com.example.gameofthrones.di.module.DataSourceModule
import com.example.gameofthrones.di.module.NetworkModule
import com.example.gameofthrones.di.module.ViewModelModule
import com.example.gameofthrones.di.subcomponents.ActivityComponent
import com.example.gameofthrones.di.subcomponents.ActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, ViewModelModule::class, NetworkModule::class, DataSourceModule::class])
interface GameOfThronesComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): GameOfThronesComponent
    }

    fun activityComponent(): ActivityComponent.Factory
}