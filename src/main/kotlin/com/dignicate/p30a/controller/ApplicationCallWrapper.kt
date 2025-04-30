package com.dignicate.p30a.controller

import io.ktor.http.*
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.*


class ApplicationCallWrapper<T: Any>(
    private val call: ApplicationCall,
) {
    suspend fun respond(result: Result<T>) {
        result.fold(
            onSuccess = { data ->
                call.respond(HttpStatusCode.OK, data as Any)
            },
            onFailure = { exception ->
                val status = when (exception) {
                    is IllegalArgumentException -> HttpStatusCode.BadRequest
                    is NoSuchElementException -> HttpStatusCode.NotFound
                    else -> HttpStatusCode.InternalServerError
                }

                val errorBody = ErrorResponse(
                    error = exception.message ?: "Unknown error",
                    status = status.value
                )
                call.respond(status, errorBody)
            }
        )
    }
}

@kotlinx.serialization.Serializable
data class ErrorResponse(
    val error: String,
    val status: Int
)

