package com.odougle.caderneta.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.odougle.caderneta.R
import com.odougle.caderneta.ui.theme.AlmostWhite
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.util.fromStringRes
import com.odougle.caderneta.view.navigation.BottomBarScreen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CadernetaBottomAppBar(navController: NavHostController, bottomState: ModalBottomSheetState) {
    BottomNavigation(
        modifier = Modifier.clip(SHAPE),
        backgroundColor = AlmostWhite
    ) {
        val coroutineScope = rememberCoroutineScope()
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

        Box(
            modifier = Modifier.width(80.dp).height(80.dp),
            contentAlignment = Center
        ) {
            IconButton(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    coroutineScope.launch {
                        bottomState.show()
                    }
                }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(id = R.string.add_button_content_description),
                    tint = Color.DarkGray
                )

            }
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