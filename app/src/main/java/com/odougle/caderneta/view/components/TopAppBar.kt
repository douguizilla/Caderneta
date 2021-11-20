package com.odougle.caderneta.view.components

import ActionItem
import ActionMenu
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.odougle.caderneta.R

@Composable
fun CadernetaTopAppBar() {
    changeStatusBarColor()
    val items = listOf(
        ActionItem(
            R.string.settings,
            painterResource(id = R.drawable.ic_settings),
            OverflowMode.ALWAYS_OVERFLOW,
            doAction = { settingsAction() })
    )

    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1, color = Color.DarkGray)
        },
        backgroundColor = Color.White,
        actions = {
            ActionMenu(items = items)
        }
    )
}

@Composable
fun changeStatusBarColor(){
    val systemUiController = rememberSystemUiController()
    if(isSystemInDarkTheme()){
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Color.White
        )
    }
}

private fun settingsAction() {
    TODO("Not yet implemented")
}

//fun TopAppBar(
//    title: @Composable () -> Unit,
//    modifier: Modifier = Modifier,
//    navigationIcon: @Composable (() -> Unit)? = null,
//    actions: @Composable RowScope.() -> Unit = {},
//    backgroundColor: Color = MaterialTheme.colors.primarySurface,
//    contentColor: Color = contentColorFor(backgroundColor),
//    elevation: Dp = AppBarDefaults.TopAppBarElevation
//)