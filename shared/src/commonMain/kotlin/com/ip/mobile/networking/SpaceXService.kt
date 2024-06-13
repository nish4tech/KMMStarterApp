package com.ip.mobile.networking

import com.ip.mobile.home.data.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SpaceXService(private val httpClient: HttpClient) {

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get("v5/launches").body()
    }
}