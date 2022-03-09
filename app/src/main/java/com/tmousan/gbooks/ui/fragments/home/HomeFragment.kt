package com.tmousan.gbooks.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.tmousan.gbooks.data.local.db.BookDatabase
import com.tmousan.gbooks.data.remote.RetrofitInstance
import com.tmousan.gbooks.databinding.FragmentHomeBinding
import com.tmousan.gbooks.repository.BooksRepository
import com.tmousan.gbooks.ui.adapter.MainAdapter
import com.tmousan.gbooks.ui.fragments.base.BaseFragment
import com.tmousan.gbooks.util.state.StateResource

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private val mainAdapter by lazy { MainAdapter() }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        observerResults()


    }

    private fun observerResults() {
        viewModel.getAll.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is StateResource.Success -> {
                    binding.rvProgressBar.visibility = View.INVISIBLE
                    response.data?.let { data ->
                        mainAdapter.differ.submitList(data.items.toList())
                    }
                }
                is StateResource.Error -> {
                    binding.rvProgressBar.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(), "Ocorreu um erro: ${response.message.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
                is StateResource.Loading-> {
                    binding.rvProgressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupRecycleView() = with(binding) {
        rvBooks.apply {
            adapter = mainAdapter
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
        

        mainAdapter.setOnClickListener { book ->
           val action = HomeFragmentDirections.actionHomeFragmentToBookFragment(book)
            findNavController().navigate(action)}


    }



    override fun getFragmentRepository(): BooksRepository = BooksRepository(
        RetrofitInstance.api, BookDatabase.invoke(requireContext()))

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
}