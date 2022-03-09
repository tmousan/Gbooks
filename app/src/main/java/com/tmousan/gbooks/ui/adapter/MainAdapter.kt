package com.tmousan.gbooks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tmousan.gbooks.databinding.ItemBooksBinding
import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

class MainAdapter : RecyclerView.Adapter<MainAdapter.BookViewHolder>(){

    inner class BookViewHolder(val binding: ItemBooksBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    private val differCallbackt = object : DiffUtil.ItemCallback<VolumeInfo>(){
        override fun areItemsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
            return oldItem.imageLinks == newItem.imageLinks
        }

        override fun areContentsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    val differt = AsyncListDiffer(this, differCallbackt)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            ItemBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        with(holder){
            with(differ.currentList[position]){
                Glide.with(holder.itemView.context).load(volumeInfo?.imageLinks?.smallThumbnail).into(binding.ivBooksImages)
                binding.tvTitle.text = volumeInfo?.title

                holder.itemView.setOnClickListener {
                    onItemClickListener?.let{ click ->
                        click(this)
                    }
                }
            }
        }
    }
    private var onItemClickListener : ((Item) -> Unit)? = null

    fun setOnClickListener (listener : (Item) -> Unit){
        onItemClickListener = listener
    }
}