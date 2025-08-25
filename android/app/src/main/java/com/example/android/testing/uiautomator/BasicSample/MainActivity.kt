package com.example.android.testing.uiautomator.BasicSample

import android.app.Activity
import android.os.Bundle
import com.example.android.testing.uiautomator.BasicSample.databinding.ActivityMainBinding

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.changeTextBt.setOnClickListener {
            // First button's interaction: set a text in a text view.
            binding.textToBeChanged.text = binding.editTextUserInput.text.toString()
        }
        binding.activityChangeTextBtn.setOnClickListener {
            // Second button's interaction: start an activity and send a message to it.
            val intent = ShowTextActivity.newStartIntent(this, binding.editTextUserInput.text.toString())
            startActivity(intent)
        }

    }
}