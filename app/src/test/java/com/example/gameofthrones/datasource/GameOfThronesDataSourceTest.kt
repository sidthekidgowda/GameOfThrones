package com.example.gameofthrones.datasource

import com.android.rxviewmodelutility.RxSchedulerRule
import com.example.gameofthrones.model.Book
import com.example.gameofthrones.room.BooksDao
import com.example.gameofthrones.service.GameOfThronesService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameOfThronesDataSourceTest {

    @get:Rule
    val rxRule = RxSchedulerRule()

    @MockK
    private lateinit var gameOfThronesService: GameOfThronesService
    @MockK
    private lateinit var booksDao: BooksDao

    private lateinit var dataSource: GameOfThronesDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        dataSource = GameOfThronesDataSourceImpl(gameOfThronesService, booksDao)
    }

    @Test
    fun `test no books in database make service calls and returns list of books`() {
        every { booksDao.getBooks() } returns Flowable.empty()
        every { gameOfThronesService.getListOfBooks() } returns Single.just(getListOfBooks())
        dataSource.getListOfBooks().test().assertValue(getListOfBooks())
    }

    @Test
    fun `test get books returns error on service call`() {
        val throwable = Throwable()

        every { booksDao.getBooks() } returns Flowable.empty()
        every { gameOfThronesService.getListOfBooks() } returns Single.error(throwable)

        dataSource.getListOfBooks().test().assertError(throwable)
    }

    @Test
    fun `test get books makes service call and updates booksDao`() {
        every { booksDao.getBooks() } returns Flowable.empty()
        every { booksDao.insertAll(any()) } returns Unit
        every { gameOfThronesService.getListOfBooks() } returns Single.just(getListOfBooks())
        dataSource.getListOfBooks().test()
        verify(exactly = 1) { booksDao.getBooks() }
        verify(exactly = 1) { booksDao.insertAll(any())}
    }

    @Test
    fun `test getBooks returns From database`() {
        every { booksDao.getBooks() } returns Flowable.just(getListOfBooks())
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