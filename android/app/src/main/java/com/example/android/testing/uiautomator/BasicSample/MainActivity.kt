package com.example.android.testing.uiautomator.BasicSample

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity: Activity() {
    private lateinit var textView: TextView
    private lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super<Activity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.changeTextBt).setOnClickListener {
            // First button's interaction: set a text in a text view.
            textView.text = editText.text.toString()
        }
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener {
            // Second button's interaction: start an activity and send a message to it.
            val intent = ShowTextActivity.newStartIntent(this, editText.text.toString())
            startActivity(intent)
        }
        textView = findViewById(R.id.textToBeChanged)
        editText = findViewById(R.id.editTextUserInput)

    }
}