package com.ip.mobile.home.data

import com.ip.mobile.networking.SpaceXApi

class SpaceXRepo {
    suspend fun getAllLaunches(): List<RocketLaunch> {
        return SpaceXApi().getAllLaunches()
    }
}