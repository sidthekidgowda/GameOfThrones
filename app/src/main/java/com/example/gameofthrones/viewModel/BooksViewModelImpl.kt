package com.example.gameofthrones.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.model.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class BooksViewModelImpl @Inject constructor(private val dataSource: GameOfThronesDataSource) :
    ViewModel(), BooksViewModel {

    private val compositeDisposable = CompositeDisposable()
    private val listOfBooksLiveData = MutableLiveData<List<Book>>()

    //View functions
    private val loadingSpinnerVisibilityLiveData = MutableLiveData<Int>()

    override fun getListOfBooks() {
        compositeDisposable.add(
            dataSource.getListOfBooks()
                .doOnSubscribe { loadingSpinnerVisibilityLiveData.postValue(View.VISIBLE) }
                .doFinally { loadingSpinnerVisibilityLiveData.postValue(View.GONE) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ books -> listOfBooksLiveData.postValue(books) },
                            { error -> Log.e("Error: ", error.message) }))
    }

    override fun getListOfBooksLiveData(): LiveData<List<Book>> {
        return listOfBooksLiveData
    }

    override fun loadingSpinnerVisibility(): LiveData<Int> {
        return loadingSpinnerVisibilityLiveData
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}