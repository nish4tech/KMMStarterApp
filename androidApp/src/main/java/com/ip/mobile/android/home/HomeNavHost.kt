package com.ip.mobile.android.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ip.mobile.android.NavTarget

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()
    NavHost(
        homeNavController,
        NavTarget.ScreenHome
    ) {
        composable<NavTarget.ScreenHome> {
            HomeScreen(
                onNextClick = {
                    homeNavController.navigate(NavTarget.ScreenAccountDetails(10))
                }
            )
        }

        composable<NavTarget.ScreenAccountDetails> {
            val args = it.toRoute<NavTarget.ScreenAccountDetails>()
            AccountDetailsScreen(id = args.accountId)
        }
    }
}