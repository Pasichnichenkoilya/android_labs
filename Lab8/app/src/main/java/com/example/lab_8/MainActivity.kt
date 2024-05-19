package com.example.lab_8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val dishes = listOf(
            Pair("Burger", "https://images.unsplash.com/photo-1571091718767-18b5b1457add"),
            Pair("Fries", "https://images.unsplash.com/photo-1598679253544-2c97992403ea"),
            Pair("Chicken wings", "https://images.unsplash.com/photo-1426869981800-95ebf51ce900"),
            Pair("Hot-dog", "https://images.unsplash.com/photo-1599599810694-b5b37304c041"),
            Pair("Tacos", "https://plus.unsplash.com/premium_photo-1672976509033-cfc634f57047"),
            Pair("Pasta", "https://images.unsplash.com/photo-1608897013039-887f21d8c804"),
        )

        val adapter = DishAdapter(dishes){ position: Int ->
            val intent = Intent(this, DishDetailsActivity::class.java)
            intent.putExtra("dishName", dishes[position].first)
            startActivity(intent)
        }

        binding.recyclerViewVert.adapter = adapter
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val animalsNames = listOf(
            "Burger",
            "Fries",
            "Chicken wings",
            "Hot-dog",
            "Tacos",
            "Pasta",
        )
        val adapterSecond = HorizontalViewAdapter(animalsNames)
        binding.recyclerViewHor.adapter = adapterSecond
    }
}