package com.example.gameofthrones.viewModel

import androidx.lifecycle.LiveData
import com.example.gameofthrones.model.Book

interface BooksViewModel {
    fun getListOfBooks()
    fun getListOfBooksLiveData(): LiveData<List<Book>>
}