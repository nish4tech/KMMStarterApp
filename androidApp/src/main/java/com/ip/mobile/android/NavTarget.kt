package com.ip.mobile.android

import kotlinx.serialization.Serializable

sealed class NavTarget {

    @Serializable
    data object ScreenLogin : NavTarget()

    @Serializable
    data object NavHostLauncher : NavTarget()

    @Serializable
    data object NavHostHome : NavTarget()

    @Serializable
    data object ScreenHome : NavTarget()

    @Serializable
    data class ScreenAccountDetails(val accountId: Int) : NavTarget()

    @Serializable
    data object NavHostSettings : NavTarget()

    @Serializable
    data object ScreenSettings : NavTarget()

    @Serializable
    data object ScreenSettingDetails : NavTarget()

    @Serializable
    data object NavHostManageFunds : NavTarget()

    @Serializable
    data object ScreenManageFunds : NavTarget()

    @Serializable
    data object ScreenManageFundDetails : NavTarget()
}