package com.doool.cleanarchitecture.presentation.main

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
    private val apiListAdapter = ApiListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        setupObserve()

        apiViewModel.loadCategory()
        apiViewModel.loadAllApi()
    }

    private fun setupRecycler() {
        with(dataBinding.apiListRecyclerView) {
            adapter = apiListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupObserve() {
        with(apiViewModel) {
            apiList.observe(viewLifecycleOwner) {
                apiListAdapter.setItems(it)
            }
        }
    }
}

