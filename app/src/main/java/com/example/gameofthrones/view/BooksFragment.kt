package com.example.gameofthrones.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.R
import com.example.gameofthrones.databinding.GotBookfragmentBinding
import com.example.gameofthrones.viewModel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.got_bookfragment.*

@AndroidEntryPoint
class BooksFragment : Fragment() {

    private lateinit var binding: GotBookfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.got_bookfragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as WelcomeActivity).setTitle(getString(R.string.books))

        val bookViewModel: BooksViewModel by viewModels()
        binding.viewModel = bookViewModel

        bookViewModel.getListOfBooks()
        bookViewModel.getListOfBooksLiveData().observe(viewLifecycleOwner, Observer { books ->
            val booksRecyclerAdapter = BooksRecyclerAdapter(context, books)
            books_recycler_view.adapter = booksRecyclerAdapter
            books_recycler_view.layoutManager = LinearLayoutManager(context)
        })

    }
}