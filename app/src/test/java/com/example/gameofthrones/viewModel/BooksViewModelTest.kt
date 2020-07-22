package com.example.gameofthrones.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.rxviewmodelutility.RxSchedulerRule
import com.example.gameofthrones.datasource.GameOfThronesDataSource
import com.example.gameofthrones.model.Book
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BooksViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @get:Rule
    val rxRule = RxSchedulerRule()

    @MockK
    private lateinit var gameOfThronesDataSource: GameOfThronesDataSource

    private lateinit var viewModel: BooksViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = BooksViewModel(gameOfThronesDataSource)
    }

    @Test
    fun `test getListOfBooks returns validListOf Books`() {
        every { gameOfThronesDataSource.getListOfBooks() } returns Single.just(getListOfBooks())

        viewModel.getListOfBooks()
        assertEquals(getListOfBooks(), viewModel.getListOfBooksLiveData().value)
    }

    @Test
    fun `test getListOfBooks returns error and BooksLiveData is null`() {
        every { gameOfThronesDataSource.getListOfBooks() } returns Single.error(Throwable())

        viewModel.getListOfBooks()
        assertNull(viewModel.getListOfBooksLiveData().value)
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