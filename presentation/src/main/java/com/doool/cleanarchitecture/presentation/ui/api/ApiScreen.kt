package com.doool.cleanarchitecture.presentation.ui.api

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doool.cleanarchitecture.presentation.model.EntryItem
import com.doool.cleanarchitecture.presentation.ui.common.AppBar
import com.doool.cleanarchitecture.presentation.ui.theme.CleanArchitectureTheme
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ApiScreen(viewModel: ApiViewModel, navigateBack: () -> Unit) {

    val category = viewModel.category ?: ""
    val apiList by viewModel.apiList.observeAsState(emptyList())

    Scaffold(topBar = {
        AppBar( title =category,onBackClick =navigateBack)
    }) {
        ApiList(apiList = apiList)
    }
}

@Composable
fun ApiList(apiList: List<EntryItem>) {
    LazyColumn(
        modifier = Modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(apiList) {
            Api(api = it)
        }
    }
}

@Composable
fun Api(api: EntryItem) {
    Column {
        Column(
            Modifier
                .padding(horizontal = 20.dp)
        ) {
            Text(text = api.api, style = MaterialTheme.typography.body1)
            Text(text = api.description, style = MaterialTheme.typography.body2)

            FlowRow(modifier = Modifier.padding(vertical = 8.dp), mainAxisSpacing = 6.dp) {
                RoundedBoxText(text = api.auth)
                RoundedBoxText(text = if (api.https) "https" else "http")
                RoundedBoxText(text = api.cors)
                RoundedBoxText(text = api.category)
            }
        }
        Divider(thickness = 0.5.dp, color = Color.Gray)
    }
}

@Composable
fun RoundedBoxText(text: String) {
    Box(
        modifier = Modifier
            .height(30.dp)
            .background(Color.White, RoundedCornerShape(15.dp))
            .border(0.5.dp, Color.Black, RoundedCornerShape(15.dp))
            .padding(horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.body1)
    }
}

@Preview
@Composable
fun PreviewApi() {
    val api = EntryItem(
        "AlienVault Open Threat Exchange (OTX)",
        "IP/domain/URL reputation",
        "apiKey",
        true,
        "unknown",
        "https://otx.alienvault.com/api",
        "Anti-Malware"
    )

    CleanArchitectureTheme {
        Api(api)
    }
}

@Preview
@Composable
fun PreviewApiList() {
    val apiList = (0..100).map {
        EntryItem(
            "AlienVault Open Threat Exchange (OTX)",
            "IP/domain/URL reputation",
            "apiKey",
            true,
            "unknown",
            "https://otx.alienvault.com/api",
            "Anti-Malware"
        )
    }

    CleanArchitectureTheme {
        ApiList(apiList)
    }
}