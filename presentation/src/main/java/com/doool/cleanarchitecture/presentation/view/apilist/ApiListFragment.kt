package com.doool.cleanarchitecture.presentation.view.apilist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.doool.cleanarchitecture.presentation.R
import com.doool.cleanarchitecture.presentation.base.BaseFragment
import com.doool.cleanarchitecture.presentation.databinding.FragmentApiListBinding
import com.doool.cleanarchitecture.presentation.viewmodel.ApiListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApiListFragment : BaseFragment<FragmentApiListBinding>(R.layout.fragment_api_list) {

    private val apiViewModel by viewModels<ApiListViewModel>()
    private val apiAdapter by lazy { ApiAdapter() }
    private val apiCategoryAdapter by lazy { ApiCategoryAdapter(apiViewModel::setCategory) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        setupObserve()

        apiViewModel.loadCategory()
        apiViewModel.loadAllApi()
    }

    private fun setupRecycler() {
        with(dataBinding.apiListRecyclerView) {
            adapter = apiAdapter
            layoutManager = LinearLayoutManager(context)
        }

        with(dataBinding.apiCategoryRecyclerView) {
            adapter = apiCategoryAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupObserve() {
        with(apiViewModel) {
            apiList.observe(viewLifecycleOwner) {
                apiAdapter.setItems(it)
            }
            categoryList.observe(viewLifecycleOwner) {
                apiCategoryAdapter.setItems(it)
            }
        }
    }
}

