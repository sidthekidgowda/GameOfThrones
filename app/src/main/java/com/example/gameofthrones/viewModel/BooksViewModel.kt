package com.example.gameofthrones.viewModel

import android.util.Log
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.rxviewmodelutility.BaseRxViewModel
import com.android.rxviewmodelutility.addUIScheduler
import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.model.Book

class BooksViewModel @ViewModelInject constructor(private val dataSource: GameOfThronesDataSource) :
    BaseRxViewModel() {

    private val listOfBooksLiveData = MutableLiveData<List<Book>>()

    //View functions
    private val loadingSpinnerVisibilityLiveData = MutableLiveData<Int>()

    fun getListOfBooks() {
        addDisposable(
            dataSource.getListOfBooks()
                .doOnSubscribe { loadingSpinnerVisibilityLiveData.postValue(View.VISIBLE) }
                .doFinally { loadingSpinnerVisibilityLiveData.postValue(View.GONE) }
                .addUIScheduler()
                .subscribe({ books -> listOfBooksLiveData.postValue(books) },
                    { error -> Log.e("Error: ", error.message) })
        )
    }

    fun getListOfBooksLiveData(): LiveData<List<Book>> {
        return listOfBooksLiveData
    }

    fun loadingSpinnerVisibility(): LiveData<Int> {
        return loadingSpinnerVisibilityLiveData
    }
}