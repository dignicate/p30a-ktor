package com.dignicate.p30a.plugins

import com.dignicate.p30a.controller.automobile.automobileRoutes
import com.dignicate.p30a.controller.common.commonRoutes
import com.dignicate.p30a.controller.time.timeRoutes
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        commonRoutes()
        automobileRoutes()
        timeRoutes()
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
    }
}
