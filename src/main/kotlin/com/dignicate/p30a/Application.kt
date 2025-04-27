package com.dignicate.p30a

import com.dignicate.p30a.controller.di.controllerModule
import com.dignicate.p30a.data.di.dataModule
import com.dignicate.p30a.domain.di.domainModule
import com.dignicate.p30a.plugins.configureRouting
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.resources.Resources
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }
    install(ContentNegotiation) {
        json()
    }
    install(Koin) {
        modules(dataModule)
        modules(domainModule)
        modules(controllerModule)
    }
    install(Resources)
    configureRouting()
}
