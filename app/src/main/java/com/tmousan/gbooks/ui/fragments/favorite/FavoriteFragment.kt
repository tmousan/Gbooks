package com.tmousan.gbooks.ui.fragments.favorite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tmousan.gbooks.R
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.remote.RetrofitInstance
import com.tmousan.gbooks.databinding.FragmentFavoriteBinding
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.ui.adapter.MainAdapter
import com.tmousan.gbooks.ui.fragments.base.BaseFragment
import com.tmousan.gbooks.util.state.BookListEvent
import com.tmousan.gbooks.util.state.BookListState

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    private val mainAdapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dispatch(BookListEvent.Fetch)
        configRecycle()
        observerResults()

    }
    private fun observerResults() {
        viewModel.favorite.observe(viewLifecycleOwner) { response ->
            when (response) {
                is BookListState.Success -> {
                    binding.tvEmptyList.visibility = View.INVISIBLE
                    mainAdapter.differ.submitList(response.list)
                }
                is BookListState.ErrorMessage -> {
                    binding.tvEmptyList.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Ocorreu um erro: ${response.errorMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is BookListState.Loading -> {
                    binding.tvEmptyList.visibility = View.INVISIBLE
                }
                is BookListState.Empty -> {
                    binding.tvEmptyList.visibility = View.VISIBLE
                    mainAdapter.differ.submitList(emptyList())
                }

            }
        }
    }

    private val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
    {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {val position = viewHolder.layoutPosition
            val mass = mainAdapter.differ.currentList[position]
            viewModel.deleteBook(mass)
            Snackbar.make(
                viewHolder.itemView,
                getString(R.string.book_delete_successful), Snackbar.LENGTH_LONG
            ).apply {
                setAction(getString(R.string.undo)){
                    viewModel.saveBook(mass)
                    mainAdapter.notifyItemInserted(position)
                }
                show()
            }
            observerResults()
        }

    }


    private fun configRecycle()= with(binding) {
        rvFavorite.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

            ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(this)
        }
//        mainAdapter.setOnClickListener { book ->
//            val action = FavoriteFragmentDirections.actionHomeFragmentToBookFragment(book)
//            findNavController().navigate(action)
//        }

    }

    override fun getViewModel(): Class<FavoriteViewModel> = FavoriteViewModel::class.java

    override fun getFragmentRepository(): BooksRepository = BooksRepository(RetrofitInstance.api, BookDatabase.invoke(requireContext()))

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
}