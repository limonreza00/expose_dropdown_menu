package com.coderscastle.exposedropdownmenu

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        val language = listOf("Arabic","English","French","German","Italian","Japanese","Korean","Portuguese","Spanish")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, language)
        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedOption = language[position]
            Toast.makeText(this@MainActivity, "Selected: $selectedOption", Toast.LENGTH_SHORT).show()
        }

    }
}