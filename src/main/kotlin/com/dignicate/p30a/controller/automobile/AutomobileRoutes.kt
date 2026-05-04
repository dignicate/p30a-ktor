package com.dignicate.p30a.controller.automobile

import com.dignicate.p30a.controller.ErrorResponse
import io.ktor.http.HttpStatusCode
import io.ktor.resources.Resource
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.resources.get
import io.ktor.server.routing.Route
import org.koin.java.KoinJavaComponent.getKoin

fun Route.automobileRoutes() {
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
}

@Resource("/")
internal class Root {
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
