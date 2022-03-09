package com.tmousan.gbooks.presenter

import com.tmousan.gbooks.data.local.model.Item
import com.tmousan.gbooks.data.local.model.VolumeInfo

interface ViewHome {

    interface View{
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showBooks(books: MutableList<Item>)
    }

    interface Favorite{
        fun showBooks(books: MutableList<VolumeInfo>)
    }
}