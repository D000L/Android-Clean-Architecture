package com.doool.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.doool.cleanarchitecture.presentation.screen.apiScreen.ApiScreen
import com.doool.cleanarchitecture.presentation.viewmodel.ApiListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ApiListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApiScreen(viewModel)
        }
    }
}