package com.tmousan.gbooks.ui.fragments.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.tmousan.gbooks.R
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo
import com.tmousan.gbooks.data.remote.RetrofitInstance
import com.tmousan.gbooks.databinding.FragmentBookBinding
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.ui.fragments.base.BaseFragment

class BookFragment : BaseFragment<BookViewModel, FragmentBookBinding>() {

    private val args: BookFragmentArgs by navArgs()
    private lateinit var book: Item
    private lateinit var volumeInfo: VolumeInfo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        book = args.book

        Glide.with(this).load(book.volumeInfo?.imageLinks?.smallThumbnail).into(binding.ivDetailImage)
        binding.tvTitle.text = book.volumeInfo?.title
        binding.tvDetailAuthor.text = book.volumeInfo?.authors.toString()
        binding.tvDetailDescription.text = book.volumeInfo?.description

        binding.fab.setOnClickListener{
            viewModel.saveBook(book)
            Snackbar.make(it, R.string.book_saved_successful, Snackbar.LENGTH_LONG).show()}

    }


    override fun getViewModel(): Class<BookViewModel> = BookViewModel::class.java

    override fun getFragmentRepository(): BooksRepository
    = BooksRepository(RetrofitInstance.api, BookDatabase.invoke(requireContext()))

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBookBinding = FragmentBookBinding.inflate(inflater, container, false)
}