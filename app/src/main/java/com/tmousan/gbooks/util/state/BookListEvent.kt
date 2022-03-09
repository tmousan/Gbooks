package com.tmousan.gbooks.util.state

sealed class BookListEvent {
    object Fetch : BookListEvent()
}