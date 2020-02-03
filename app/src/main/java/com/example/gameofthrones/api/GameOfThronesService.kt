package com.example.gameofthrones.api

import com.example.gameofthrones.model.Book
import io.reactivex.Single
import retrofit2.http.GET

interface GameOfThronesService {

    /**
     * Base url = "https://www.anapioficeandfire.com/api/"
     */

    @GET("books")
    fun getListOfBooks(): Single<List<Book>>
}