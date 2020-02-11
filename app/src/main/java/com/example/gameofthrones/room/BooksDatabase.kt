package com.example.gameofthrones.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gameofthrones.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BooksDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao
}