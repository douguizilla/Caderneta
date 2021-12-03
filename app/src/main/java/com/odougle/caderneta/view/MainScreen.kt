package com.odougle.caderneta.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.ComposableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.R
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.util.SPACER_HEIGHT
import com.odougle.caderneta.view.components.CadernetaBottomAppBar
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomNavGraph
import com.odougle.caderneta.view.screens.AddItems
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var selection by remember {
        mutableStateOf(0)
    }
    val content: @Composable (() -> Unit) = { Options() }
    var sheetContent by remember { mutableStateOf(content) }
    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = SHAPE,
        sheetContent = {
            sheetContent()
        }
    ) {
        BottomNavGraph(navHostController = navController)

        when (selection) {
            0 -> {
                sheetContent = {
                    Column {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = true) {
                                    selection = 1
                                }

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_income),
                                contentDescription = stringResource(id = R.string.income_button_content_description)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.income_button_content_description))
                        }
                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = true) {
                                    selection = 2
                                }

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_income),
                                contentDescription = stringResource(id = R.string.income_button_content_description)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.income_button_content_description))
                        }
                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = true) {
                                    selection = 3
                                }

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_income),
                                contentDescription = stringResource(id = R.string.income_button_content_description)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.income_button_content_description))
                        }
                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

                    }

                }
            }

            1 -> {
                sheetContent = { NewIncome() }
            }
        }

        Scaffold(
            topBar = { CadernetaTopAppBar() },
            bottomBar = {
                CadernetaBottomAppBar(
                    navController = navController,
                    bottomState = bottomState
                )
            }
        ) {
            BottomNavGraph(navHostController = navController)
        }


    }
}

@Composable
fun Options() {
    Column(modifier = Modifier.padding(16.dp)) {
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_income,
            contentDescription = stringResource(R.string.add_button_content_description),
            spacerHeight = 16.dp,
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_outlay,
            contentDescription = stringResource(R.string.outlay_button_content_description),
            spacerHeight = 16.dp
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_goals,
            contentDescription = stringResource(R.string.goals_button_content_description),
            spacerHeight = 16.dp
        )
    }
}

@Composable
fun AddBottomSheetItem(
    drawableIconId: Int,
    contentDescription: String,
    spacerHeight: Dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {

            }

    ) {
        Icon(
            painter = painterResource(id = drawableIconId),
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contentDescription)
    }
    Spacer(modifier = Modifier.height(spacerHeight))
}

//https://dev.to/davidibrahim/how-to-use-multiple-bottom-sheets-in-android-compose-382p
