package com.dogukanincee.butterknifeimplementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    private val _mainViewData = MutableLiveData<ViewData>()

    val mainViewData: LiveData<ViewData>
        get() = _mainViewData

    fun loadData() {
        // Load data from a repository or another source
        _mainViewData.value = ViewData(
            titleText = "Welcome to ButterKnife app!",
            buttonText = "Click me!"
        )
    }

}