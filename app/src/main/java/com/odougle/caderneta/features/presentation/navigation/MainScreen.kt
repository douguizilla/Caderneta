package com.odougle.caderneta.features.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.features.presentation.components.CadernetaBottomAppBar
import com.odougle.caderneta.features.presentation.components.CadernetaTopAppBar
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewGoal
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewIncome
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewOutlay
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.Options
import com.odougle.caderneta.features.presentation.util.TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val selectionAux = remember { mutableStateOf(0) }
    var selection by remember { mutableStateOf(0) }

    val content: @Composable (() -> Unit) = {
        Options(selection = selectionAux)
    }

    var sheetContent by remember { mutableStateOf(content) }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = bottomState,
        sheetShape = TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE,
        sheetContent = {
            sheetContent()
        }
    ) {
        when (selection) {
            1 -> {
                sheetContent = { NewIncome(navController = navController, bottomSheetState = bottomState) }
            }
            2 -> {
                sheetContent = { NewOutlay(navController = navController, bottomSheetState = bottomState) }
            }
            3 -> {
                sheetContent = { NewGoal(navController = navController, bottomSheetState = bottomState) }
            }
        }

        if (bottomState.isVisible) {

        } else {
            selection = 0
            selectionAux.value = 0
            sheetContent = {
                Options(selection = selectionAux)
            }
        }

        selection = selectionAux.value

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { CadernetaTopAppBar() },
            bottomBar = {
                CadernetaBottomAppBar(
                    navController = navController,
                    bottomState = bottomState
                )
            }
        ) { paddingValues ->
            BottomNavGraph(
                navHostController = navController,
                paddingValues = paddingValues,
                sheetContent,
                bottomState
            )
        }
    }
}