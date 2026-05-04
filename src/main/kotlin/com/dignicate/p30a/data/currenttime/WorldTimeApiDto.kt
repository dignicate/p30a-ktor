package com.dignicate.p30a.data.currenttime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorldTimeApiResponse(
    @SerialName("utc_datetime")
    val utcDatetime: String,
    @SerialName("unixtime")
    val unixtime: Long
)
