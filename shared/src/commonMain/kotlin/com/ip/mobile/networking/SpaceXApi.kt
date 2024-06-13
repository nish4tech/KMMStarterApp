package com.ip.mobile.networking

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SpaceXApi {

    companion object {
        const val BASE_URL = "api.spacexdata.com"

        fun prepareClient(partnerId: String = "", authToken: String = ""): HttpClient = HttpClient {
            expectSuccess = true
            install(HttpTimeout) {
                requestTimeoutMillis = 5 * 60 * 1000
                connectTimeoutMillis = 5 * 60 * 1000
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }
            install(DefaultRequest) {
                headers {
                    append("Authorization", "Bearer $authToken")
                    append("PartnerID", partnerId)
                }
            }

            defaultRequest {
                host = BASE_URL
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

}





