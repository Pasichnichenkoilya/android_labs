package com.example.lab_8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_8.databinding.DishDetailsBinding

class DishDetailsActivity : AppCompatActivity() {
    private lateinit var binding: DishDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DishDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishName = intent.getStringExtra("dishName")
        binding.dishDetailsButton.text = dishName
    }
}
