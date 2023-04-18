package com.dogukanincee.butterknifeimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import butterknife.BindView
import butterknife.ButterKnife

/**
 * MainActivity for ButterKnifeImplementation app.
 */
class MainActivity : AppCompatActivity() {

    // Lazily initialized ViewModel instance
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    // ButterKnife binding of title TextView
    @BindView(R.id.title_textview)
    lateinit var titleTextView: TextView

    // ButterKnife binding of button
    @BindView(R.id.button)
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views using ButterKnife
        ButterKnife.bind(this)

        // Observe the LiveData from ViewModel to update the UI when data is changed
        viewModel.mainViewData.observe(this) { viewData ->
            titleTextView.text = viewData.titleText
            button.text = viewData.buttonText
        }

        // Set click listener for the button to update the text
        button.setOnClickListener {
            showToast("Button clicked!")
            viewModel.updateButtonText()
        }

        // Load initial data from ViewModel
        viewModel.loadData()
    }

    /**
     * Shows a Toast message with the given message string.
     *
     * @param message Message to be displayed in the Toast.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}