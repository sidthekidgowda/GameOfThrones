package com.example.gameofthrones.di.subcomponents

import com.example.gameofthrones.di.viewModel.ViewModelModule
import com.example.gameofthrones.view.BooksFragment
import com.example.gameofthrones.view.WelcomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: WelcomeActivity)
    fun inject(fragment: BooksFragment)
}