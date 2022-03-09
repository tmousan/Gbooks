package com.tmousan.rickmortyapp.util

import android.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


internal class UtilQueryTextListener (
    lifecycle: Lifecycle, private val utilQueryTextListener: (String?) -> Unit
): SearchView.OnQueryTextListener, LifecycleObserver{

    private val coroutineScope = lifecycle.coroutineScope
    private var filterJob: Job? = null

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        filterJob?.cancel()
        filterJob = coroutineScope.launch {
            newText?.let {
                delay(500L)
                utilQueryTextListener(newText)
            }
        }
        return false
    }

}