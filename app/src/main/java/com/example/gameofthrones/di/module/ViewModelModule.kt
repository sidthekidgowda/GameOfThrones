package com.example.gameofthrones.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.viewmodelfactory.ViewModelFactory
import com.android.viewmodelfactory.ViewModelKey
import com.example.gameofthrones.viewModel.BooksViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BooksViewModelImpl::class)
    abstract fun bindsBooksViewModel(viewModel: BooksViewModelImpl): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}