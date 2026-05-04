package com.dignicate.p30a.domain.currenttime

interface CurrentTimeRepository {
    suspend fun getCurrentTime(): Result<CurrentTime>
}
