package com.odougle.caderneta.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odougle.caderneta.view.screens.*
import com.odougle.caderneta.view.screens.HomeScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Income.route){
            IncomeScreen()
        }

        composable(route = BottomBarScreen.AddBill.route){
            AddBillScreen()
        }

        composable(route = BottomBarScreen.Outlay.route){
            OutlayScreen()
        }

        composable(route = BottomBarScreen.Goals.route){
            GoalsScreen()
        }
    }
}