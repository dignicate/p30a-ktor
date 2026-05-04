package com.dignicate.p30a.controller.time

@kotlinx.serialization.Serializable
data class CurrentTimeResponse(
    val utc: String,
    val millis: Long,
    val unixSeconds: Long,
    val iso8601: String
)
