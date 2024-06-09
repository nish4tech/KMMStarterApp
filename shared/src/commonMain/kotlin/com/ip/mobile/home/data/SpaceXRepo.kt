package com.ip.mobile.home.data

import com.ip.mobile.networking.SpaceXApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SpaceXRepo {
    suspend fun getAllLaunches(): Flow<List<RocketLaunch>> = flow {
        emit(SpaceXApi().getAllLaunches())
    }
}