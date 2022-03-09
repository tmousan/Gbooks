package com.tmousan.gbooks.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmousan.gbooks.ui.adapter.MainAdapter
import com.tmousan.gbooks.databinding.ActivityFavoriteBinding
import com.tmousan.gbooks.data.local.model.VolumeInfo

import com.tmousan.gbooks.presenter.ViewHome


//class FavoriteActivity : AppCompatActivity(), ViewHome.Favorite {
//
//    private val mainAdapter by lazy {
//        MainAdapter()
//    }
//    private lateinit var presenter: FavoritePresenter
//    private lateinit var binding: ActivityFavoriteBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFavoriteBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        val dataSource = BooksDataSource(this)
//        presenter = FavoritePresenter(this, dataSource)
//        presenter.getAll()
//
//        configRecycle()
//        clickAdapter()
//
//    }
//
//
//
//    private fun configRecycle(){
//        with(binding.rvFavorite){
//            adapter = mainAdapter
//            layoutManager = LinearLayoutManager(this@FavoriteActivity)
//            addItemDecoration(DividerItemDecoration(this@FavoriteActivity, DividerItemDecoration.VERTICAL))
//
//
//        }
//    }
//
//    private fun clickAdapter(){
//        mainAdapter.setOnClickListener { book ->
//            val intent = Intent(this, FavoriteActivity::class.java)
//            intent.putExtra("book", book)
//            startActivity(intent)
//        }
//    }
//
//    override fun showBooks(books: MutableList<VolumeInfo>) {
//        mainAdapter.differt.submitList(books)
//    }
//
//}


