package com.dignicate.p30a.data.time

import com.dignicate.p30a.domain.time.CurrentTime
import com.dignicate.p30a.domain.time.CurrentTimeRepository
import java.time.Instant

class CurrentTimeRepositoryImpl(
) : CurrentTimeRepository {

    override suspend fun getCurrentTime(): Result<CurrentTime> {
        return Result.success(CurrentTime(instant = Instant.now()))
    }
}
