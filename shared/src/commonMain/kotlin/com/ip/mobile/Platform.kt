package com.ip.mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform