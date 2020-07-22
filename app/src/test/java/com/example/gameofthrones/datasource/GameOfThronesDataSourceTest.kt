package com.example.gameofthrones.datasource

import com.android.rxviewmodelutility.RxSchedulerRule
import com.example.gameofthrones.model.Book
import com.example.gameofthrones.room.BooksDao
import com.example.gameofthrones.room.BooksDatabase
import com.example.gameofthrones.service.GameOfThronesService
import io.reactivex.Flowable
import io.reactivex.Single
import org.intellij.lang.annotations.Flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GameOfThronesDataSourceTest {

    @get:Rule
    val rxRule = RxSchedulerRule()

    @Mock
    private lateinit var gameOfThronesService: GameOfThronesService
    @Mock
    private lateinit var booksDao: BooksDao

    private lateinit var dataSource: GameOfThronesDataSource

    @Before
    fun setup() {
        dataSource = GameOfThronesDataSourceImpl(gameOfThronesService, booksDao)
        `when`(gameOfThronesService.getListOfBooks()).thenReturn(Single.just(getListOfBooks()))
    }

    @Test
    fun `test no books in database make service calls and returns list of books`() {
        `when`(booksDao.getBooks()).thenReturn(Flowable.empty())

        dataSource.getListOfBooks().test().assertValue(getListOfBooks())
    }

    @Test
    fun `test no books in database make service calls and updates database`() {
        `when`(booksDao.getBooks()).thenReturn(Flowable.empty())
        dataSource.getListOfBooks().test().assertValue(getListOfBooks())

    }

    private fun getListOfBooks(): List<Book> {

        val bookOne = Book(
            "123",
            "www.google.com/gameofthrones",
            "Fire And Ice",
            listOf("James R.R. Martin"),
            230,
            "today",
            listOf()
        )
        val bookTwo = Book(
            "456",
            "www.google.com/gameofthrones",
            "Dragon Wars",
            listOf("James R.R. Martin"),
            500,
            "today",
            listOf()
        )

        return listOf(bookOne, bookTwo)
    }
}