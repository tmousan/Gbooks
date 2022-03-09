package com.tmousan.gbooks.presenter.favorite

import com.tmousan.gbooks.data.local.model.VolumeInfo

interface FavoriteHome {

    interface Presenter{
        fun onSuccess(books: MutableList<VolumeInfo>)
    }


}