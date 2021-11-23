package com.odougle.caderneta.view

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.view.components.CadernetaBottomAppBar
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomNavGraph
import com.odougle.caderneta.view.screens.AddItems

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = SHAPE,
        sheetContent = {
            AddItems()
        }
    ) {
        BottomNavGraph(navHostController = navController)

        Scaffold(
            topBar = { CadernetaTopAppBar() },
            bottomBar = { CadernetaBottomAppBar(navController = navController, bottomState = bottomState) }
        ) {
            BottomNavGraph(navHostController = navController)
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
