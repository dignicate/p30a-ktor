package com.dignicate.p30a.controller

@kotlinx.serialization.Serializable
data class ErrorResponse(
    val error: String,
    val statusCode: Int
)
