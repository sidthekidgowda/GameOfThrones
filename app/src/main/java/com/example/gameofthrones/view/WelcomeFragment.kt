package com.example.gameofthrones.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gameofthrones.R
import kotlinx.android.synthetic.main.got_mainfragment.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.got_mainfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as WelcomeActivity).setTitle(getString(R.string.game_of_thrones))

        goto_books_button.setOnClickListener {
            (activity as WelcomeActivity).supportFragmentManager
                .beginTransaction()
                .replace(id, BooksFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}