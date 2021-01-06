package com.doool.cleanarchitecture.ui.splash

import android.os.Bundle
import androidx.activity.viewModels
import com.doool.cleanarchitecture.R
import com.doool.cleanarchitecture.databinding.ActivityMainBinding
import com.doool.cleanarchitecture.ui.base.BaseActivity
import com.doool.cleanarchitecture.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.checkServerOn()
    }
}