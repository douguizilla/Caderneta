package com.odougle.caderneta.features.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.features.presentation.components.Bar.TopBarType
import com.odougle.caderneta.features.presentation.components.CadernetaBottomAppBar
import com.odougle.caderneta.features.presentation.components.CadernetaTopAppBar
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewGoal
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewIncome
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.NewOutlay
import com.odougle.caderneta.features.presentation.screens.bottomSheetDialogs.Options
import com.odougle.caderneta.features.presentation.util.TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val topBar : MutableState<TopBarType> = remember{ mutableStateOf(TopBarType.Default)}

    val selectionAux = remember { mutableStateOf(0) }
    var selection by remember { mutableStateOf(0) }

    val content: @Composable (() -> Unit) = {
        Options(selection = selectionAux)
    }

    var sheetContent : MutableState<(@Composable ()-> Unit)> = remember { mutableStateOf(content) }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = bottomState,
        sheetShape = TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE,
        sheetContent = {
            sheetContent.value()
        }
    ) {
        when (selection) {
            1 -> {
                sheetContent.value =  {NewIncome(navController = navController, bottomSheetState = bottomState) }
            }
            2 -> {
                sheetContent.value = { NewOutlay(navController = navController, bottomSheetState = bottomState) }
            }
            3 -> {
                sheetContent.value = { NewGoal(navController = navController, bottomSheetState = bottomState) }
            }
        }

        if (bottomState.isVisible) {

        } else {
            selection = 0
            selectionAux.value = 0
            sheetContent.value = {
                Options(selection = selectionAux)
            }
        }

        selection = selectionAux.value

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { CadernetaTopAppBar(topBar) },
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
                bottomState,
                topBar
            )
        }
    }
}