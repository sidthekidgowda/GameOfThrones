package com.example.gameofthrones.di.subcomponents

import com.example.gameofthrones.di.datasource.DataSourceModule
import com.example.gameofthrones.view.BooksFragment
import com.example.gameofthrones.view.WelcomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DataSourceModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: WelcomeActivity)
    fun inject(fragment: BooksFragment)
}