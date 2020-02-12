package com.example.gameofthrones.di.subcomponents

import com.example.gameofthrones.di.module.DataSourceModule
import com.example.gameofthrones.view.BooksFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DataSourceModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(fragment: BooksFragment)
}