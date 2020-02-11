package com.example.gameofthrones.di.module

import android.app.Application
import androidx.room.Room
import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.datasource.GameOfThronesDataSourceImpl
import com.example.gameofthrones.room.BooksDao
import com.example.gameofthrones.room.BooksDatabase
import com.example.gameofthrones.service.GameOfThronesService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    fun bindsDataSource(service: GameOfThronesService,
                        database: BooksDatabase): GameOfThronesDataSource {
        return GameOfThronesDataSourceImpl(service, database)
    }

    @Provides
    @Singleton
    fun providesBooksDatabase(app: Application): BooksDatabase {
        return Room.databaseBuilder(app, BooksDatabase::class.java, "books_db")
            .build()
    }

    @Provides
    @Singleton
    fun providesBooksDao(database: BooksDatabase): BooksDao {
        return database.booksDao()
    }
}
