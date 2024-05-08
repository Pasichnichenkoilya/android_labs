package com.example.lab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getParcelableExtra<Product>("product")

        if (product != null) {
            binding.textViewName.setText("Name: ${product.name}")
            binding.textViewCourse.setText("Price: ${product.price}")
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
    }
}