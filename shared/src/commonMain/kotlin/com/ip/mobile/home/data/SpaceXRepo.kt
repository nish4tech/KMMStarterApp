package com.ip.mobile.home.data

import com.ip.mobile.networking.SpaceXApi
import com.ip.mobile.networking.SpaceXService

class SpaceXRepo {
    suspend fun getAllLaunches(): List<RocketLaunch> {
        val client = SpaceXApi.prepareClient()
        return SpaceXService(client).getAllLaunches()
    }
}