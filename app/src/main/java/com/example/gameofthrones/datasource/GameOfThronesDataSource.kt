package com.example.gameofthrones.datasource

import com.example.gameofthrones.model.Book
import io.reactivex.Single

interface GameOfThronesDataSource {

    fun getListOfBooks(): Single<List<Book>>
}