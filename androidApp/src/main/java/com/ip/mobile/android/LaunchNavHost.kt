package com.ip.mobile.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.android.home.HomeNavHost
import com.ip.mobile.android.manage_funds.ManageFundsNavHost
import com.ip.mobile.android.settings.SettingsNavHost

@Composable
fun LaunchNavHost() {
    val rootNavController = rememberNavController()
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    val isSelected = item.target.javaClass.canonicalName ==
                            navBackStackEntry?.destination?.route
                    NavigationBarItem(
                        selected = isSelected,
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (isSelected) {
                                    item.selectedIcon
                                } else
                                    item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        onClick = {
                            rootNavController.navigate(item.target) {
                                popUpTo(rootNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )


                }

            }
        }
    ) { padding ->
        NavHost(
            rootNavController,
            startDestination = NavTarget.NavHostHome
        ) {
            composable<NavTarget.NavHostHome> {
                HomeNavHost()
            }
            composable<NavTarget.NavHostSettings> {
                SettingsNavHost()
            }
            composable<NavTarget.NavHostManageFunds> {
                ManageFundsNavHost()
            }
        }

    }
}

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        target = NavTarget.NavHostHome,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavigationItem(
        title = "Settings",
        target = NavTarget.NavHostSettings,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings
    ),
    BottomNavigationItem(
        title = "Manage Funds",
        target = NavTarget.NavHostManageFunds,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart
    )
)

data class BottomNavigationItem(
    val title: String,
    val target: NavTarget,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)