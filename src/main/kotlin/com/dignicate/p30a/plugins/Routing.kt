package com.dignicate.p30a.plugins

import com.dignicate.p30a.controller.ErrorResponse
import com.dignicate.p30a.controller.automobile.AutomobileController
import io.ktor.http.*
import io.ktor.resources.Resource
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.resources.get
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay
import org.koin.java.KoinJavaComponent.getKoin

fun Application.configureRouting() {
    routing {
        get<Root> {
            call.respondRedirect(Url("https://freeapi.dignicate.com/swagger"))
        }
        get<Root.Redirect> { request ->
            delay(request.delayMs)
            call.respondRedirect(request.url)
        }
        get<Root.Automobile.V1.Companies> { request ->
            val controller: AutomobileController = getKoin().get()
            try {
                val companies = controller.getCompanies(request.limit, request.page)
                call.respond(HttpStatusCode.OK, companies)
            } catch (e: IllegalArgumentException) {
                call.respond(HttpStatusCode.BadRequest, ErrorResponse(e.message ?: "Invalid input", 400))
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Unexpected error", 500))
            }
        }
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
    }
}

@Resource("/")
private class Root {
    @Resource("/redirect")
    class Redirect(
        @Suppress("unused")
        val parent: Root = Root(),
        val delayMs: Long = 0L,
        val url: String,
    )

    @Resource("/automobile")
    class Automobile(
        @Suppress("unused")
        val parent: Root = Root()
    ) {
        @Resource("/v1")
        class V1(
            @Suppress("unused")
            val parent: Automobile = Automobile()
        ) {
            @Resource("/companies")
            class Companies(
                @Suppress("unused")
                val parent: V1 = V1(),
                val limit: Int = 10,
                val page: Int = 1
            )
        }
    }
}
