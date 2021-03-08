package com.doool.cleanarchitecture.presentation.view.apilist

import androidx.recyclerview.widget.RecyclerView
import com.doool.cleanarchitecture.presentation.databinding.ItemCategoryBinding

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: String, isSelected: Boolean, onClickCategory: () -> Unit) {
        with(binding) {
            categoryContainer.setOnClickListener { onClickCategory() }
            categoryContainer.isSelected = isSelected
            categoryTitle.text = category
        }
    }
}