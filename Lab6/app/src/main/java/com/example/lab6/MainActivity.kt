package com.example.lab6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val productParam = intent.getParcelableExtra<Product>("product")
        if (productParam != null) {
            binding.nameText.setText(product.name)
            binding.courseText.setText(product.price)
        }

        product = Product("Phone", 25000)
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("product", Product(binding.nameText.text.toString(), binding.courseText.text.toString().toInt()))
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("product", product)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        product = savedInstanceState.getParcelable("product")!!
    }
}