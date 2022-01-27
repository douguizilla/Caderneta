package com.odougle.caderneta.features.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odougle.caderneta.view.screens.*
import com.odougle.caderneta.view.screens.HomeScreen

@ExperimentalMaterialApi
@Composable
fun BottomNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    sheetContent: MutableState<(@Composable () -> Unit)>,
    bottomState: ModalBottomSheetState
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                paddingValues = paddingValues,
                sheetContent = sheetContent,
                bottomState = bottomState
            )
        }

        composable(route = BottomBarScreen.Income.route){
            IncomeScreen(
                paddingValues = paddingValues,
                sheetContent = sheetContent,
                bottomState = bottomState
            )
        }

        composable(route = BottomBarScreen.Outlay.route){
            OutlayScreen(
                paddingValues = paddingValues,
                sheetContent = sheetContent,
                bottomState = bottomState
            )
        }

        composable(route = BottomBarScreen.Goals.route){
            GoalsScreen(
                paddingValues = paddingValues,
                sheetContent = sheetContent,
                bottomState = bottomState
            )
        }
    }
}