package com.dignicate.p30a.plugins

import io.ktor.client.request.get
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.config.MapApplicationConfig
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class VersionHeadersTest {
    @Test
    fun `adds app version header to responses`() = testApplication {
        environment {
            config = MapApplicationConfig("app.version" to "0.1.0")
        }

        application {
            install(VersionHeaders)
            routing {
                get("/ping") {
                    call.respondText("ok")
                }
            }
        }

        val response = client.get("/ping")

        assertEquals("0.1.0", response.headers[AppVersionHeaderName])
    }
}
