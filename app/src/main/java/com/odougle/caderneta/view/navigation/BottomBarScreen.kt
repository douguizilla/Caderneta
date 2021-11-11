package com.odougle.caderneta.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val contentDescription: String
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Início",
        icon = Icons.Default.List,
        contentDescription = "Tela inicial"
    )

    object Income: BottomBarScreen(
        route = "income",
        title = "Receitas",
        icon = Icons.Default.More,
        contentDescription = "Tela das suas receitas"
    )

    object AddBill: BottomBarScreen(
        route = "addBill",
        title = "Add",
        icon = Icons.Default.Add,
        contentDescription = "Botão para adicionar novas despesas, receitas ou metas"
    )

    object Outlay: BottomBarScreen(
        route = "outlay",
        title = "Despesas",
        icon = Icons.Default.Minimize,
        contentDescription = "Tela das suas despesas"
    )

    object Goals: BottomBarScreen(
        route = "goals",
        title = "Metas",
        icon = Icons.Default.Upgrade,
        contentDescription = "Tela das suas metas"
    )
}
