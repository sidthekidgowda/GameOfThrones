package com.example.gameofthrones.di.module

import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.datasource.GameOfThronesDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindsDataSource(dataSource: GameOfThronesDataSourceImpl): GameOfThronesDataSource
}