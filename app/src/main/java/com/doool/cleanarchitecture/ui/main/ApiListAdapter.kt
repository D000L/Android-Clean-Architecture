package com.doool.cleanarchitecture.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doool.cleanarchitecture.R
import com.doool.cleanarchitecture.databinding.ItemApiBinding
import com.doool.cleanarchitecture.ui.model.EntryItem

class ApiListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<EntryItem> = mutableListOf()

    fun setItems(entryList: List<EntryItem>) {
        items.clear()
        items.addAll(entryList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        val binding = ItemApiBinding.bind(view)
        return ApiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ApiViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    private inner class ApiViewHolder(private val binding: ItemApiBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: EntryItem) {
            with(binding) {
                apiName.text = data.api
                apiDescription.text = data.description
                apiCategory.text = data.category
                apiLink.text = data.link
                apiHttps.text = "Https : " + if (data.https) "Ok" else "No"
                apiCors.text = "Cors : " + data.cors
                apiAuth.text = data.auth
            }
        }
    }
}