package com.example.gameofthrones.datasource

import com.example.gameofthrones.model.Book
import com.example.gameofthrones.room.BooksDao
import com.example.gameofthrones.service.GameOfThronesService
import io.reactivex.Single
import javax.inject.Inject

class GameOfThronesDataSourceImpl @Inject constructor(private val gameOfThronesService: GameOfThronesService,
                                                      private val booksDao: BooksDao) : GameOfThronesDataSource {

    companion object {
        const val TAG = "GameOfThronesDataSource"
    }

    override fun getListOfBooks(): Single<List<Book>> {

        //retrieve from cache using dao if cache isn't empty
        //make service call if cache does not exist

        return booksDao.getBooks()
            .take(1)
            .toObservable()
            .filter {!it.isEmpty()}
            .firstOrError()
            .onErrorResumeNext {
                gameOfThronesService.getListOfBooks()
                    .doOnSuccess { booksDao.insertAll(it) }
            }
    }
}