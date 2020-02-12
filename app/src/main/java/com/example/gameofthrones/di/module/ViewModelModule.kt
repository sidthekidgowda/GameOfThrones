package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gameofthrones.viewModel.ViewModelFactory
import com.example.gameofthrones.viewModel.ViewModelKey
import com.example.gameofthrones.viewModel.BooksViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BooksViewModelImpl::class)
    abstract fun bindsBooksViewModel(viewModel: BooksViewModelImpl): ViewModel
}