package com.odougle.caderneta.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.odougle.caderneta.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val contentDescription: String
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Início",
        icon = R.drawable.ic_home,
        contentDescription = "Tela inicial"
    )

    object Income: BottomBarScreen(
        route = "income",
        title = "Receitas",
        icon = R.drawable.ic_income,
        contentDescription = "Tela das suas receitas"
    )

    object AddBill: BottomBarScreen(
        route = "addBill",
        title = "Add",
        icon = R.drawable.ic_add,
        contentDescription = "Botão para adicionar novas despesas, receitas ou metas"
    )

    object Outlay: BottomBarScreen(
        route = "outlay",
        title = "Despesas",
        icon = R.drawable.ic_outlay,
        contentDescription = "Tela das suas despesas"
    )

    object Goals: BottomBarScreen(
        route = "goals",
        title = "Metas",
        icon = R.drawable.ic_goals,
        contentDescription = "Tela das suas metas"
    )
}
