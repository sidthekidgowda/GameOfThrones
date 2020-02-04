package com.example.gameofthrones.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.R
import com.example.gameofthrones.viewModel.BooksViewModelImpl
import kotlinx.android.synthetic.main.got_bookfragment.*
import javax.inject.Inject

class BooksFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.got_bookfragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as WelcomeActivity).activityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookViewModel = ViewModelProvider(this, viewModelFactory).get(BooksViewModelImpl::class.java)

        //start spinner
        loading_spinner.visibility = View.VISIBLE
        bookViewModel.getListOfBooks()
        bookViewModel.getListOfBooksLiveData().observe(viewLifecycleOwner, Observer { books ->
            books_recycler_view.visibility = View.VISIBLE
            loading_spinner.visibility = View.GONE
            val booksRecyclerAdapter = BooksRecyclerAdapter(context, books)
            books_recycler_view.adapter = booksRecyclerAdapter
            books_recycler_view.layoutManager = LinearLayoutManager(context)
        })

    }
}