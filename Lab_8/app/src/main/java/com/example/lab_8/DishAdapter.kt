package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class DishAdapter (private val items: List<Pair<String, String?>>,
                   private val onItemClick: (position: Int) -> Unit):
                    RecyclerView.Adapter<DishAdapter.DishHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return DishHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: DishHolder, position: Int) {
        val dishName = items[position]
        holder.bind(dishName.first, dishName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DishHolder(private val binding: RecycleViewBinding,
                     private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.dishButton.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }

            fun bind(animalName: String, imageUrl: String?) {
                Glide.with(binding.imageView)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(binding.imageView.drawable)
                    .error(R.drawable.ic_launcher_background)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView)
                binding.dishButton.text = animalName
        }
    }
}