package com.example.gameofthrones.datasource

import com.example.gameofthrones.api.GameOfThronesService
import com.example.gameofthrones.model.Book
import io.reactivex.Single
import javax.inject.Inject

class GameOfThronesDataSourceImpl @Inject constructor(private val gameOfThronesService: GameOfThronesService) : GameOfThronesDataSource {

    override fun getListOfBooks(): Single<List<Book>> {
        return gameOfThronesService.getListOfBooks()
    }
}