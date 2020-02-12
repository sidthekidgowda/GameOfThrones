package com.example.gameofthrones.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.R
import com.example.gameofthrones.databinding.GotBookfragmentBinding
import com.example.gameofthrones.viewModel.BooksViewModelImpl
import kotlinx.android.synthetic.main.got_bookfragment.*
import javax.inject.Inject

class BooksFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as WelcomeActivity).activityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as WelcomeActivity).setTitle(getString(R.string.books))
        (activity as WelcomeActivity).supportActionBar?.setHomeButtonEnabled(true)
        (activity as WelcomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bookViewModel = ViewModelProvider(this, viewModelFactory).get(BooksViewModelImpl::class.java)
        binding.viewModel = bookViewModel

        bookViewModel.getListOfBooks()
        bookViewModel.getListOfBooksLiveData().observe(viewLifecycleOwner, Observer { books ->
            val booksRecyclerAdapter = BooksRecyclerAdapter(context, books)
            books_recycler_view.adapter = booksRecyclerAdapter
            books_recycler_view.layoutManager = LinearLayoutManager(context)
        })

    }
}