package com.example.gameofthrones.datasource

import com.example.gameofthrones.model.Book
import com.example.gameofthrones.room.BooksDatabase
import com.example.gameofthrones.service.GameOfThronesService
import io.reactivex.Single
import javax.inject.Inject

class GameOfThronesDataSourceImpl @Inject constructor(private val gameOfThronesService: GameOfThronesService,
                                                      private val database: BooksDatabase) : GameOfThronesDataSource {

    override fun getListOfBooks(): Single<List<Book>> {
        return gameOfThronesService.getListOfBooks()
    }
}