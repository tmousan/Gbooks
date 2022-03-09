package com.tmousan.gbooks.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.tmousan.gbooks.R
import com.tmousan.gbooks.databinding.ActivityBookBinding
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

import com.tmousan.gbooks.presenter.ViewHome




//class BookActivity : AppCompatActivity(), ViewHome.Favorite {
//
//    private lateinit var book: Item
//    private lateinit var presenter: FavoritePresenter
//    private lateinit var binding: ActivityBookBinding
//    private lateinit var volumeInfo: VolumeInfo
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityBookBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        getBook()
//        val dataSource = BooksDataSource(this)
//        presenter = FavoritePresenter(this, dataSource)
//
//
//        Glide.with(this).load(book.volumeInfo?.imageLinks?.smallThumbnail).into(binding.ivDetailImage)
//        binding.tvTitle.text = book.volumeInfo?.title
//        binding.tvDetailAuthor.text = book.volumeInfo?.authors.toString()
//        binding.tvDetailDescription.text = book.volumeInfo?.description
//
//        binding.fab.setOnClickListener{
//            dataSource.saveBook(book.volumeInfo!!)
//            Snackbar.make(it, R.string.book_saved_successful, Snackbar.LENGTH_LONG).show()
//
//        }
//    }
//
//    private fun getBook(){
//        intent.extras?.let { bookSend ->
//            book = bookSend.get("book") as Item
//
//        }
//    }
//
//    override fun showBooks(books: MutableList<VolumeInfo>) {}
//}