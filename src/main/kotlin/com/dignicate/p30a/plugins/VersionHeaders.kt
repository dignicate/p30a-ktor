package com.dignicate.p30a.plugins

import com.dignicate.p30a.appVersion
import io.ktor.server.application.createApplicationPlugin

const val AppVersionHeaderName = "X-App-Version"

val VersionHeaders = createApplicationPlugin(name = "VersionHeaders") {
    val version = application.appVersion

    onCall { call ->
        call.response.headers.append(AppVersionHeaderName, version)
    }
}
