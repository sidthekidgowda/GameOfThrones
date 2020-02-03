package com.example.gameofthrones.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.model.Book
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BooksViewModelImpl @Inject constructor() : ViewModel(), BooksViewModel {

    private val listOfBooksLiveData = MutableLiveData<List<Book>>()


    private val compositeDisposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
    }

    override fun getListOfBooks() {
        //use data source
//        compositeDisposable.add()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListOfBooksLiveData(): LiveData<List<Book>> {
        return listOfBooksLiveData
    }
}