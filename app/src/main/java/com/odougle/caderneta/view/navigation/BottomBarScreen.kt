package com.odougle.caderneta.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Início",
        icon = Icons.Default.List
    )

    object Income: BottomBarScreen(
        route = "income",
        title = "Receitas",
        icon = Icons.Default.List
    )

    object AddBill: BottomBarScreen(
        route = "addBill",
        title = "Add",
        icon = Icons.Default.Add
    )

    object Outlay: BottomBarScreen(
        route = "outlay",
        title = "Despesas",
        icon = Icons.Default.List
    )

    object Goals: BottomBarScreen(
        route = "goals",
        title = "Metas",
        icon = Icons.Default.Info
    )
}
