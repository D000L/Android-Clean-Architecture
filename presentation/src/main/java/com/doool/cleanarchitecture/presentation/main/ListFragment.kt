package com.doool.cleanarchitecture.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.doool.cleanarchitecture.presentation.R
import com.doool.cleanarchitecture.presentation.base.BaseFragment
import com.doool.cleanarchitecture.presentation.databinding.FragmentListBinding
import com.doool.cleanarchitecture.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val viewPagerAdapter by lazy { ListPagerAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        setupObserve()

        mainViewModel.loadCategory()
        mainViewModel.loadAllApi()
    }

    private fun setupRecycler() {
        with(dataBinding.listViewPager) {
            adapter = viewPagerAdapter
        }
    }

    private fun setupObserve() {
        with(mainViewModel) {
            categoryList.observe(viewLifecycleOwner) {
                viewPagerAdapter.setCategories(it)
            }
        }
    }
}

class ListPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val items: MutableList<String> = mutableListOf()

    fun setCategories(categories: List<String>) {
        items.clear()
        items.addAll(categories)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment = ApiListFragment()
}


