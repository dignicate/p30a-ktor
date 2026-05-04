package com.dignicate.p30a.domain.time

interface CurrentTimeRepository {
    suspend fun getCurrentTime(): Result<CurrentTime>
}
