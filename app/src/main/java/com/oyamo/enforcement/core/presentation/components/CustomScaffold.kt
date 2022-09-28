package com.oyamo.enforcement.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.oyamo.enforcement.core.presentation.ui.theme.MainVariant
import com.oyamo.enforcement.core.presentation.ui.theme.GrayColor
import com.oyamo.enforcement.core.presentation.ui.theme.MainWhiteColor
import com.oyamo.enforcement.feature_home.domain.model.BottomNavItem


@Composable
fun CustomScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Profile,
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(
                    backgroundColor = MainWhiteColor,
                    elevation = 5.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                               Column(
                                   horizontalAlignment = Alignment.CenterHorizontally
                               ) {
                                   Icon(
                                       painter = painterResource(id = item.icon),
                                       contentDescription = null,
                                       modifier = Modifier.size(24.dp)
                                   )

                                   Text(
                                       text = item.destination.uppercase(),
                                       fontSize = 15.sp
                                   )
                               }
                            },
                            selectedContentColor = MainVariant,
                            unselectedContentColor = GrayColor,
                            selected = currentDestination?.route?.contains(item.destination) == true,
                            onClick = {
                                navController.navigate(item.destination) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
