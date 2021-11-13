package com.odougle.caderneta.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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

    BottomNavigation {
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
    BottomNavigationItem(
        label = { Text(text = screen.title, fontSize = 10.sp) },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = screen.contentDescription)},
        selected = currentDestination?.hierarchy?.any {
                      it.route == screen.route
        } == true,
        onClick = {
            navcontroler.navigate(screen.route)
        })
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
