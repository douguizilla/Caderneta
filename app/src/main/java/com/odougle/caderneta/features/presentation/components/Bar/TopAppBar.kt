package com.odougle.caderneta.features.presentation.components

import ActionItem
import ActionMenu
import OverflowMode
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.odougle.caderneta.R
import com.odougle.caderneta.features.presentation.components.Bar.TopBarType

@Composable
fun CadernetaTopAppBar(topBar: MutableState<TopBarType>) {
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