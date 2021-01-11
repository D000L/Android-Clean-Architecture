package com.doool.cleanarchitecture.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doool.cleanarchitecture.presentation.R
import com.doool.cleanarchitecture.presentation.base.BaseFragment
import com.doool.cleanarchitecture.presentation.databinding.FragmentStartBinding
import com.doool.cleanarchitecture.presentation.viewmodel.StartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding>(R.layout.fragment_start) {

    private val splashViewModel by viewModels<StartViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserve()

        splashViewModel.checkServerOn()
    }

    private fun setupObserve() {
        with(splashViewModel) {
            serverOn.observe(viewLifecycleOwner) {
                dataBinding.startServerState.text = if (it) "Server On" else "Server Off"
                if (it) {
                    findNavController().navigate(StartFragmentDirections.actionStartFragmentToListFragment())
                } else {
                    activity?.finish()
                }
            }
        }
    }
}