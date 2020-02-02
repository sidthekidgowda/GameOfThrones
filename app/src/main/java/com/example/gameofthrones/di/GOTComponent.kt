package com.example.gameofthrones.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@Component
interface GOTComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): GOTComponent
    }
}