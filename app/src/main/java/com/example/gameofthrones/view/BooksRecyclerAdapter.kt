package com.example.gameofthrones.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.R
import com.example.gameofthrones.databinding.BookRowBinding
import com.example.gameofthrones.model.Book

class BooksRecyclerAdapter(private val context: Context?,
                           private val books: List<Book>) : RecyclerView.Adapter<BooksRecyclerAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(
            BookRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = books[position]
        holder.bind(context, book)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BooksViewHolder(private val binding: BookRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context:Context?, book: Book) {
            val noOfPages = "${book.numberOfPages} ${context?.getString(R.string.number_of_pages)}"
            binding.bookTitle = book.bookName
            binding.bookAuthor = "${context?.getString(R.string.author)} ${book.authors.first()}"
            binding.bookPages = noOfPages
            binding.bookDate = book.getFormattedDate()
        }
    }
}
