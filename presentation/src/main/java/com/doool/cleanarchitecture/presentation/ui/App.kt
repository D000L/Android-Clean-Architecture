package com.doool.cleanarchitecture.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.doool.cleanarchitecture.presentation.ui.api.ApiScreen
import com.doool.cleanarchitecture.presentation.ui.api.ApiViewModel
import com.doool.cleanarchitecture.presentation.ui.api.CategoryScreen
import com.doool.cleanarchitecture.presentation.ui.category.CategoryViewModel

object MainDestinations {
    const val CATEGORY_ROUTE = "category"
    const val API_LIST_ROUTE = "apiList"
}

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.CATEGORY_ROUTE
) {
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.CATEGORY_ROUTE) {
            val categoryViewModel: CategoryViewModel = hiltViewModel()

            CategoryScreen(
                viewModel = categoryViewModel,
                navigateApiList = actions::navigateToApiList
            )
        }
        composable(
            route = "${MainDestinations.API_LIST_ROUTE}/{${ApiViewModel.CATEGORY_KEY}}",
            arguments = listOf(navArgument(ApiViewModel.CATEGORY_KEY) { type = NavType.StringType })
        ) { backStackEntry ->
            val apiViewModel: ApiViewModel = hiltViewModel(backStackEntry)

            ApiScreen(
                viewModel = apiViewModel,
                navigateBack = actions::navigateUp
            )
        }
    }
}

class MainActions(private val navController: NavHostController) {

    fun navigateToApiList(category: String?) {
        navController.navigate("${MainDestinations.API_LIST_ROUTE}/$category")
    }

    fun navigateUp() {
        navController.navigateUp()
    }
}