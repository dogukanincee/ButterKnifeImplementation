package com.dogukanincee.butterknifeimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    @BindView(R.id.title_textview)
    lateinit var titleTextView: TextView

    @BindView(R.id.button)
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        viewModel.mainViewData.observe(this) { viewData ->
            titleTextView.text = viewData.titleText
            button.text = viewData.buttonText
        }

        button.setOnClickListener { showToast("Button clicked!") }
        viewModel.loadData()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}