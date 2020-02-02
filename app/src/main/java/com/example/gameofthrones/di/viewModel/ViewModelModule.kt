package com.example.gameofthrones.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.viewModel.BooksViewModel
import com.example.gameofthrones.viewModel.BooksViewModelImpl
import dagger.Binds
import dagger.Module
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @ViewModelKey(BooksViewModelImpl::class)
    abstract fun bindsBooksViewModel(viewModel: BooksViewModelImpl): ViewModel
}