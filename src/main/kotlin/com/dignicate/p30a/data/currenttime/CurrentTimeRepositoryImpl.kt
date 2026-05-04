package com.dignicate.p30a.data.currenttime

import com.dignicate.p30a.domain.currenttime.CurrentTime
import com.dignicate.p30a.domain.currenttime.CurrentTimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Instant

class CurrentTimeRepositoryImpl(
    private val httpClient: HttpClient = HttpClient.newHttpClient(),
    private val json: Json = Json { ignoreUnknownKeys = true }
) : CurrentTimeRepository {

    override suspend fun getCurrentTime(): Result<CurrentTime> {
        return try {
            val request = HttpRequest.newBuilder()
                .uri(URI.create("https://worldtimeapi.org/api/timezone/UTC"))
                .GET()
                .build()

            val response = kotlinx.coroutines.withContext(Dispatchers.IO) {
                httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            }
            if (response.statusCode() !in 200..299) {
                return Result.failure(IllegalStateException("WorldTimeAPI returned status ${response.statusCode()}"))
            }

            val payload = json.decodeFromString(WorldTimeApiResponse.serializer(), response.body())
            val instant = Instant.ofEpochSecond(payload.unixtime)
            Result.success(CurrentTime(instant = instant))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
