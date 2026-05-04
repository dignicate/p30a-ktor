package com.dignicate.p30a.domain.currenttime

class GetCurrentTimeUseCase(
    private val repository: CurrentTimeRepository
) {
    suspend fun execute(): CurrentTime {
        return repository.getCurrentTime().fold(
            onSuccess = { it },
            onFailure = { throw it }
        )
    }
}
