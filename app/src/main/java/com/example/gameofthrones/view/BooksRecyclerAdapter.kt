package com.example.gameofthrones.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.model.Book

class BooksRecyclerAdapter(private val context: Context?,
                           private val books: List<Book>) : RecyclerView.Adapter<BooksRecyclerAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BooksViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        //@TODO set up layout for book
    }
}