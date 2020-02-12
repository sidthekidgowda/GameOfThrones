package com.example.gameofthrones.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gameofthrones.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
@TypeConverters(BooksTypeConverter::class)
abstract class BooksDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao
}