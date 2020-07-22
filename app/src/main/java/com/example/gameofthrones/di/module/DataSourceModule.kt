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
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun bindsDataSource(service: GameOfThronesService,
                        booksDao: BooksDao): GameOfThronesDataSource {
        return GameOfThronesDataSourceImpl(service, booksDao)
    }

    @Provides
    fun providesBooksDatabase(app: Application): BooksDatabase {
        return Room.databaseBuilder(app, BooksDatabase::class.java, "books_db")
            .build()
    }

    @Provides
    fun providesBooksDao(database: BooksDatabase): BooksDao {
        return database.booksDao()
    }
}
