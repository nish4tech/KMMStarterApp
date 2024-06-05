package com.ip.mobile.android.common

import androidx.navigation.NavHostController
import com.ip.mobile.android.NavTarget

fun NavHostController.navigateWithPopUp(
    toRoute: NavTarget,
    fromRoute: NavTarget
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true
        }
    }
}