package com.example.lab_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.lab_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            showText("Button 1 clicked")
        }

        binding.button2.setOnClickListener {
            showText("Button 2 clicked")
        }

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (!s.isNullOrEmpty()) {
                    val message = "Before text changed"
                    showText(message)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    val message = "Text changed"
                    showText(message)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                binding.textView.text = s.toString()
            }
        })

        binding.editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showText("EditText focused")
            } else {
                showText("EditText lost focus")
            }
        }

    }

    private fun showText(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}