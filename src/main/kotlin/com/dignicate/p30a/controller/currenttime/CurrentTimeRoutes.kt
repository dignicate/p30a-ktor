package com.dignicate.p30a.controller.currenttime

import com.dignicate.p30a.controller.ErrorResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.java.KoinJavaComponent.getKoin

fun Route.currentTimeRoutes() {
    get("/current-time") {
        val controller: CurrentTimeController = getKoin().get()
        try {
            call.respond(HttpStatusCode.OK, controller.getCurrentTime())
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Unexpected error", 500))
        }
    }
}
