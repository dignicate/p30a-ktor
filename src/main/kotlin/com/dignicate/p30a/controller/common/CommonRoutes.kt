package com.dignicate.p30a.controller.common

import io.ktor.http.Url
import io.ktor.resources.Resource
import io.ktor.server.response.respondRedirect
import io.ktor.server.resources.get
import io.ktor.server.routing.Route
import kotlinx.coroutines.delay

fun Route.commonRoutes() {
    get<Root> {
        call.respondRedirect(Url("https://freeapi.dignicate.com/swagger"))
    }
    get<Root.Redirect> { request ->
        delay(request.delayMs)
        call.respondRedirect(request.url)
    }
}

@Resource("/")
internal class Root {
    @Resource("/redirect")
    class Redirect(
        @Suppress("unused")
        val parent: Root = Root(),
        val delayMs: Long = 0L,
        val url: String,
    )
}
