package com.dignicate.p30a.data.automobile

import com.dignicate.p30a.data.common.MongoDbClientWrapper
import com.dignicate.p30a.domain.automobile.AutomobileRepository
import com.dignicate.p30a.domain.automobile.Company

class AutomobileRepositoryImpl(
    private val mongoDbClient: MongoDbClientWrapper
) : AutomobileRepository {

    override suspend fun getCompanies(limit: Int, page: Int): List<Company> {
        return try {
            mongoDbClient
                .findAll("company", CompanyDto::class.java, limit, page)
                .map { it.toDomain() }
        } catch (e: Exception) {
            println("MongoDB error: ${e.message}")
            throw e
        }
    }
}

private fun CompanyDto.toDomain(): Company = Company(
    id = _id,
    name = name,
    country = emptyList(), // todo:
    foundedYear = foundedYear
)
