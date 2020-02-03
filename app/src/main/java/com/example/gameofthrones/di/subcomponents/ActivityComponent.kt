package com.example.gameofthrones.di.subcomponents

import com.example.gameofthrones.view.BooksFragment
import com.example.gameofthrones.view.WelcomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: WelcomeActivity)
    fun inject(fragment: BooksFragment)
}