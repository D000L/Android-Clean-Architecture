package com.doool.cleanarchitecture.presentation.view.apilist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doool.cleanarchitecture.presentation.R
import com.doool.cleanarchitecture.presentation.databinding.ItemCategoryBinding

class ApiCategoryAdapter(private val onClickCategory: (String?) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<String> = mutableListOf()

    private var selectedPosition = 0

    fun setItems(categoryList: List<String>) {
        items.clear()
        items.addAll(categoryList)
        notifyDataSetChanged()
    }

    private fun setSelectedItem(position: Int) {
        notifyItemChanged(selectedPosition)
        selectedPosition = position
        notifyItemChanged(selectedPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        val binding = ItemCategoryBinding.bind(view)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val category = items[position]
        (holder as CategoryViewHolder).bind(category, selectedPosition == position) {
            if (position == 0) onClickCategory(null) else onClickCategory(category)
            setSelectedItem(position)
        }
    }

    override fun getItemCount(): Int = items.size
}


