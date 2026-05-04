package com.dignicate.p30a.controller.currenttime

import com.dignicate.p30a.domain.currenttime.GetCurrentTimeUseCase
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class CurrentTimeController(
    private val getCurrentTimeUseCase: GetCurrentTimeUseCase
) {
    suspend fun getCurrentTime(): CurrentTimeResponse {
        val currentTime = getCurrentTimeUseCase.execute()
        val instant = currentTime.instant

        return CurrentTimeResponse(
            utc = DateTimeFormatter.ISO_INSTANT.format(instant),
            millis = instant.toEpochMilli(),
            unixSeconds = instant.epochSecond,
            iso8601 = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(instant.atOffset(ZoneOffset.UTC))
        )
    }
}
