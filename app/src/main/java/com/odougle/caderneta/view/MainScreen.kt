package com.odougle.caderneta.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.R
import com.odougle.caderneta.util.fromStringRes
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomBarScreen
import com.odougle.caderneta.view.navigation.BottomNavGraph
import com.odougle.caderneta.view.screens.AddItems
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = shape,
        sheetContent = {
            AddItems()
        }
    ) {
        BottomNavGraph(navHostController = navController)

        Scaffold(
            topBar = { CadernetaTopAppBar() },
            bottomBar = {

                BottomNavigation(
                    modifier = Modifier.clip(shape),
                    backgroundColor = Color.LightGray
                ) {

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    AddItem(
                        screen = BottomBarScreen.Home,
                        currentDestination = currentDestination,
                        navcontroler = navController
                    )

                    AddItem(
                        screen = BottomBarScreen.Income,
                        currentDestination = currentDestination,
                        navcontroler = navController
                    )

                    IconButton(onClick = {
                        coroutineScope.launch {
                            bottomState.show()
                        }
                    }) {
                        Icon(
                            Icons.Rounded.Add,
                            contentDescription = stringResource(id = R.string.add_button_content_description)
                        )
                    }

                    AddItem(
                        screen = BottomBarScreen.Outlay,
                        currentDestination = currentDestination,
                        navcontroler = navController
                    )

                    AddItem(
                        screen = BottomBarScreen.Goals,
                        currentDestination = currentDestination,
                        navcontroler = navController
                    )
                }
            }
        ) {
            BottomNavGraph(navHostController = navController)
        }
    }

    /*
    https://stackoverflow.com/questions/67744381/jetpack-compose-scaffold-modal-bottom-sheet
    preciso colocar a bottom sheet pra aparecer na frente da bottom nav
     */

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
        label = { Text(text = screen.title.fromStringRes(), fontSize = 10.sp, color = textColor) },
        icon = {

            Box(
                modifier = Modifier
                    .width(40.dp)
                    .background(iconBackgroundColor, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = screen.contentDescription.fromStringRes(),
                    tint = iconColor
                )
            }
        },
        selected = isSelected,
        onClick = {
            navcontroler.navigate(screen.route)
        })

}

@ExperimentalMaterialApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
