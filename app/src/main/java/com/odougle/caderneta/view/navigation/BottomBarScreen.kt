package com.odougle.caderneta.view.navigation

import androidx.annotation.StringRes
import com.odougle.caderneta.R
import com.odougle.caderneta.util.ROUTE_GOALS
import com.odougle.caderneta.util.ROUTE_HOME
import com.odougle.caderneta.util.ROUTE_INCOME
import com.odougle.caderneta.util.ROUTE_OUTLAY

sealed class BottomBarScreen(
    val route: String,
    @StringRes val title: Int,
    val icon: Int,
    @StringRes val contentDescription: Int
){
    object Home: BottomBarScreen(
        route = ROUTE_HOME,
        title = R.string.home_bottom_navigation_title,
        icon = R.drawable.ic_home,
        contentDescription = R.string.home_button_content_description
    )

    object Income: BottomBarScreen(
        route = ROUTE_INCOME,
        title = R.string.income_bottom_navigation_title,
        icon = R.drawable.ic_income,
        contentDescription = R.string.income_button_content_description
    )

    object Outlay: BottomBarScreen(
        route = ROUTE_OUTLAY,
        title = R.string.outlay_bottom_navigation_title,
        icon = R.drawable.ic_outlay,
        contentDescription = R.string.outlay_button_content_description
    )

    object Goals: BottomBarScreen(
        route = ROUTE_GOALS,
        title = R.string.goals_bottom_navigation_title,
        icon = R.drawable.ic_goals,
        contentDescription = R.string.goals_button_content_description
    )
}
