package com.dogukanincee.butterknifeimplementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for the main activity.
 */
class ViewModel : ViewModel() {

    private val _mainViewData = MutableLiveData<ViewData>()

    /**
     * LiveData for the main view data.
     */
    val mainViewData: LiveData<ViewData>
        get() = _mainViewData

    /**
     * Load data for the main view.
     */
    fun loadData() {
        // Load data from a repository or another source
        _mainViewData.postValue(
            ViewData(
                titleText = "Welcome to ButterKnife app!",
                buttonText = "Click me!"
            )
        )
    }

    /**
     * Update the button text when clicked.
     */
    fun updateButtonText() {
        val currentData = _mainViewData.value
        if (currentData != null) {
            val newText = "${currentData.titleText} clicked!"
            _mainViewData.postValue(currentData.copy(titleText = newText))
        }
    }
}