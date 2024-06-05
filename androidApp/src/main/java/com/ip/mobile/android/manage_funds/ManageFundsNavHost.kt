package com.ip.mobile.android.manage_funds

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.android.NavTarget

@Composable
fun ManageFundsNavHost() {
    val manageFundsNavController = rememberNavController()
    NavHost(
        manageFundsNavController,
        NavTarget.ScreenManageFunds
    ) {
        composable<NavTarget.ScreenManageFunds> {
            ManageFundsScreen(
                onNextClick = {
                    manageFundsNavController.navigate(NavTarget.ScreenManageFundDetails)
                }
            )
        }

        composable<NavTarget.ScreenManageFundDetails> {
            ManageFundsDetailsScreen()
        }
    }
}