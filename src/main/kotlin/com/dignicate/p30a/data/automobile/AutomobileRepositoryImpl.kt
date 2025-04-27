package com.dignicate.p30a.data.automobile

import com.dignicate.p30a.data.common.MongoDbClientWrapper
import com.dignicate.p30a.domain.automobile.AutomobileRepository
import com.dignicate.p30a.domain.automobile.Company

class AutomobileRepositoryImpl(
    private val mongoDbClient: MongoDbClientWrapper
) : AutomobileRepository {

    override suspend fun getCompanies(limit: Int, page: Int): List<Company> {
        return mongoDbClient.findAll("companies", Company::class.java, limit, page)
    }
}