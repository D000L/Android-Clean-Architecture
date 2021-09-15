package com.doool.cleanarchitecture.presentation.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewAppBar() {
    AppBar(title = "Category")
}

@Composable
fun AppBar(title: String, onBackClick: () -> Unit = {}) {
    TopAppBar {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
        Text(text = title)
    }
}
