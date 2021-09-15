package com.doool.cleanarchitecture.presentation.ui.api

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doool.cleanarchitecture.presentation.ui.category.CategoryViewModel

@Composable
fun CategoryScreen(viewModel: CategoryViewModel, navigateApiList: (String) -> Unit) {

    val categoryList by viewModel.categoryList.observeAsState(emptyList())

    CategoryGrid(categoryList = categoryList, navigateApiList)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryGrid(categoryList: List<String>, onClick: (String) -> Unit) {
    BoxWithConstraints {
        val cellCount = 3
        val cellSpacing = 6.dp
        val cellSize = this.maxWidth / cellCount - cellSpacing

        val categoryCellList = categoryList.chunked(cellCount)

        LazyColumn(
            contentPadding = PaddingValues(6.dp),
            verticalArrangement = Arrangement.spacedBy(cellSpacing)
        ) {
            items(categoryCellList) {
                Row(horizontalArrangement = Arrangement.spacedBy(cellSpacing)) {
                    it.forEach {
                        Category(
                            modifier = Modifier.size(cellSize),
                            category = it,
                            onClick = {
                                onClick(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Category(modifier: Modifier = Modifier, category: String, onClick: () -> Unit) {
    Box(modifier = modifier
        .background(Color.Blue)
        .clickable { onClick() }) {
        Text(modifier = Modifier.align(Alignment.Center), text = category)
    }
}

@Preview
@Composable
fun PreviewCategory() {
    Category(category = "Category", onClick = {})
}

@Preview
@Composable
fun PreviewCategoryList() {
    CategoryGrid(
        categoryList = listOf(
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category",
            "Category"
        ), onClick = {}
    )
}