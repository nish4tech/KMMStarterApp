package com.ip.mobile.android.settings

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.android.NavTarget

@Composable
fun SettingsNavHost() {
    val settingsNavController = rememberNavController()
    NavHost(
        settingsNavController,
        NavTarget.ScreenSettings
    ) {
        composable<NavTarget.ScreenSettings> {
            SettingsScreen(
                onNextClick = {
                    settingsNavController.navigate(NavTarget.ScreenSettingDetails)
                }
            )
        }
        composable<NavTarget.ScreenSettingDetails> {
            SettingsDetailsScreen()
        }
    }
}