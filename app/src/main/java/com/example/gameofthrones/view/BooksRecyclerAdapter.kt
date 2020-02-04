package com.example.gameofthrones.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones.model.Book

class BooksRecyclerAdapter(private val context: Context?,
                           private val books: List<Book>) : RecyclerView.Adapter<BooksRecyclerAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {

    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BooksViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}