package com.ip.mobile.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ip.mobile.android.LaunchNavHost
import com.ip.mobile.android.NavTarget
import com.ip.mobile.android.common.navigateWithPopUp
import com.ip.mobile.android.onboarding.LoginScreen

@Composable
fun StarterNavHost() {

    val starterNavController = rememberNavController()
    NavHost(
        starterNavController,
        NavTarget.ScreenLogin
    ) {
        composable<NavTarget.ScreenLogin> {
            LoginScreen(
                onNextClick = {
                    starterNavController.navigateWithPopUp(
                        NavTarget.NavHostLauncher,
                        NavTarget.ScreenLogin
                    )
                }
            )
        }

        composable<NavTarget.NavHostLauncher> {
            LaunchNavHost()
        }
    }
}



