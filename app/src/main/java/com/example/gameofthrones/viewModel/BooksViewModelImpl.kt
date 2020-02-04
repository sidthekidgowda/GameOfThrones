package com.example.gameofthrones.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.model.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BooksViewModelImpl @Inject constructor(private val dataSource: GameOfThronesDataSource) : ViewModel(), BooksViewModel {

    private val listOfBooksLiveData = MutableLiveData<List<Book>>()
    private val compositeDisposable = CompositeDisposable()

    override fun getListOfBooks() {
        compositeDisposable.add(
            dataSource.getListOfBooks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { books -> listOfBooksLiveData.postValue(books) })
    }

    override fun getListOfBooksLiveData(): LiveData<List<Book>> {
        return listOfBooksLiveData
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}