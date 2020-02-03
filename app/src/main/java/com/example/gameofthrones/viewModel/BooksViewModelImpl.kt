package com.example.gameofthrones.viewModel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BooksViewModelImpl @Inject constructor() : ViewModel(), BooksViewModel {


    override fun onCleared() {
        //@TODO - dispose of
        super.onCleared()
    }
}