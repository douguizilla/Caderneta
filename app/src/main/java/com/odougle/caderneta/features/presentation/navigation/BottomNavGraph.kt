package com.odougle.caderneta.features.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odougle.caderneta.view.screens.*
import com.odougle.caderneta.view.screens.HomeScreen

@ExperimentalMaterialApi
@Composable
fun BottomNavGraph(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(paddingValues = paddingValues)
        }

        composable(route = BottomBarScreen.Income.route){
            IncomeScreen(paddingValues = paddingValues)
        }

        composable(route = BottomBarScreen.Outlay.route){
            OutlayScreen(paddingValues = paddingValues)
        }

        composable(route = BottomBarScreen.Goals.route){
            GoalsScreen(paddingValues = paddingValues)
        }
    }
}