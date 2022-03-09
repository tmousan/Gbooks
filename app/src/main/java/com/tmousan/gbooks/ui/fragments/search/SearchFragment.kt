package com.tmousan.gbooks.ui.fragments.search

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.remote.RetrofitInstance
import com.tmousan.gbooks.databinding.FragmentSearchBinding
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.ui.adapter.MainAdapter
import com.tmousan.gbooks.ui.fragments.base.BaseFragment
import com.tmousan.gbooks.util.state.StateResource
import com.tmousan.rickmortyapp.util.UtilQueryTextListener

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    private val mainAdapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupRecycleView()
        obeserverResults()
//        search()

    }


//    private fun setupRecycleView() = with(binding) {
//        searchBook.apply {
//            adapter = mainAdapter
//            layoutmanager = LinearLayoutManager(context)
//
//            addItemDecoration(
//                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//            )
//        }
//
//        mainAdapter.setOnClickListener {
//            val action =
//                SearchFragmentDirections.actionSearchFragmentToFavoriteFragment(it)
//            findNavController().navigate(action)
//        }
//    }

//    fun search(){
//        binding.searchBook.setOnQueryTextListener(
//            UtilQueryTextListener(
//                this.lifecycle
//            ){ newText ->
//                newText?.let { query ->
//                    if( query.isNotEmpty()){
//                        sendMessage(query)
//                        getButton(query)
//                    }
//
//                }
//            }
//        )
//    }

//    private fun sendMessage(query: String) {
//        status?.let { viewModel.fetchSearch(query) }
//        binding.rvProgressBarSearch.visibility = View.VISIBLE
//        getButton(query)
//    }


    private fun obeserverResults() {
        viewModel.search.observe(viewLifecycleOwner, Observer{ response ->
            when(response){
                is StateResource.Success -> {
                    binding.rvProgressBarSearch.visibility = View.INVISIBLE
                    response.data?.let { data ->
                        mainAdapter.differ.submitList(data.items)
                    }
                }
                is StateResource.Error -> {
                    binding.rvProgressBarSearch.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(), "Ocorreu um erro: ${response.message.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
                is StateResource.Loading-> {
                    binding.rvProgressBarSearch.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun getFragmentRepository(): BooksRepository =
        BooksRepository(RetrofitInstance.api, BookDatabase.invoke(requireContext()))

    override fun getViewModel(): Class<SearchViewModel>  = SearchViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding  = FragmentSearchBinding.inflate(inflater, container, false)
}