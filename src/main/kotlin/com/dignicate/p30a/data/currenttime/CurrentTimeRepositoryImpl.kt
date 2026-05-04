package com.dignicate.p30a.data.currenttime

import com.dignicate.p30a.domain.currenttime.CurrentTime
import com.dignicate.p30a.domain.currenttime.CurrentTimeRepository
import java.time.Instant

class CurrentTimeRepositoryImpl(
) : CurrentTimeRepository {

    override suspend fun getCurrentTime(): Result<CurrentTime> {
        return Result.success(CurrentTime(instant = Instant.now()))
    }
}
