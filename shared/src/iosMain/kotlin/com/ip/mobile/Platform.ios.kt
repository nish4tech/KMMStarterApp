package com.ip.mobile

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin


actual val httpEngine: HttpClientEngine by lazy {
    Darwin.create {
        configureRequest{
            setAllowsCellularAccess(true)
        }
    }
}
