package com.example.gameofthrones.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gameofthrones.model.Book
import io.reactivex.Flowable

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(books: List<Book>)

    @Query("SELECT * FROM books")
    fun getBooks(): Flowable<List<Book>>
}