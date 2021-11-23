package com.odougle.caderneta.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.util.fromStringRes
import com.odougle.caderneta.view.components.CadernetaBottomAppBar
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomBarScreen
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
