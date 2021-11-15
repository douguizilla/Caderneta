package com.odougle.caderneta.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.view.navigation.BottomBarScreen
import com.odougle.caderneta.view.navigation.BottomNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navcontroler = navController) }
    ) {
        BottomNavGraph(navHostController = navController)
    }
}

@Composable
fun BottomBar(navcontroler: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Income,
        BottomBarScreen.AddBill,
        BottomBarScreen.Outlay,
        BottomBarScreen.Goals
    )


    val navBackStackEntry by navcontroler.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
    BottomNavigation(
        modifier = Modifier.clip(shape),
        backgroundColor = Color.LightGray,
        elevation = 10.dp
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navcontroler = navcontroler
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navcontroler: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    val iconBackgroundColor = if (isSelected) Color.White else Color.Transparent

    val textColor = if (isSelected) Color.Black else Color.DarkGray

    val iconColor = if (isSelected) Color.Black else Color.DarkGray

    BottomNavigationItem(
        label = { Text(text = screen.title, fontSize = 10.sp, color = textColor) },
        icon = {

            Box(
                modifier = Modifier
                    .width(40.dp)
                    .background(iconBackgroundColor, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = screen.contentDescription,
                    tint = iconColor
                )
            }
        },
        selected = isSelected,
        onClick = {
            navcontroler.navigate(screen.route)
        })

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
