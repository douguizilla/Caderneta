package com.odougle.caderneta.features.presentation.components

import ActionItem
import ActionMenu
import OverflowMode
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.odougle.caderneta.R
import com.odougle.caderneta.features.presentation.components.Bar.TopBarType
import com.odougle.caderneta.features.presentation.screens.CadernetaViewModel

@Composable
fun CadernetaTopAppBar(
    topBar: MutableState<TopBarType>,
    viewModel : CadernetaViewModel = hiltViewModel()
) {
    changeStatusBarColor()
    when(topBar.value){
        is TopBarType.Default -> {
            val items = listOf(
                ActionItem(
                    R.string.settings,
                    painterResource(id = R.drawable.ic_settings),
                    OverflowMode.ALWAYS_OVERFLOW,
                    doAction = { settingsAction() })
            )

            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h1,
                        color = Color.DarkGray
                    )
                },
                backgroundColor = Color.White,
                actions = {
                    ActionMenu(items = items)
                }
            )
        }

        is TopBarType.Delete -> {
            val items = listOf(
                ActionItem(
                    R.string.delete,
                    painterResource(id = R.drawable.ic_delete),
                    OverflowMode.NEVER_OVERFLOW,
                    doAction = { deleteAction() })
            )

            var count by remember{ mutableStateOf(0) }
            count = viewModel.selectedIncomesCount.value

            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = CenterVertically
                    ){
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Remover seleções"
                            )
                        }
                        Text(text = "$count")

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(text = if (count > 1) "selecionados" else "selecionado")
                    }
                },
                backgroundColor = Color.White,
                actions = {
                    ActionMenu(items = items)
                }
            )
        }
    }

}

@Composable
fun changeStatusBarColor() {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Color.White
        )
    }
}

private fun settingsAction() {

}

private fun deleteAction(){

}