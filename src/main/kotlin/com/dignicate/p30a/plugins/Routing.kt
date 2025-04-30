package com.dignicate.p30a.plugins

import com.dignicate.p30a.controller.automobile.AutomobileController
import io.ktor.http.*
import io.ktor.resources.Resource
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.resources.get
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.getKoin

fun Application.configureRouting() {
    routing {
        get<Root> {
            call.respondRedirect(Url("https://freeapi.dignicate.com/swagger"))
        }
        get<Root.Automobile.V1.Companies> { companies ->
            val controller: AutomobileController = getKoin().get<AutomobileController> { parametersOf(call) }
            controller.getCompanies(companies.limit, companies.page)
        }
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")
    }
}

@Resource("/")
private class Root {
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
