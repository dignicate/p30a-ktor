package com.dignicate.p30a.data.automobile

import com.dignicate.p30a.data.common.MongoDbClientWrapper
import com.dignicate.p30a.domain.automobile.AutomobileRepository
import com.dignicate.p30a.domain.automobile.Company
import com.dignicate.p30a.domain.automobile.Country

class AutomobileRepositoryImpl(
    private val mongoDbClient: MongoDbClientWrapper,
    private val countryDataStore: CountryDataStore,
) : AutomobileRepository {

    override suspend fun getCompanies(limit: Int, page: Int): Result<List<Company>> {
        return try {
            val allCountries = countryDataStore.getOrLoad { getCountries() }.getOrNull().orEmpty()
            val dtos = mongoDbClient
                .findAll("company", CompanyDto::class.java, limit, page)
            val companies = dtos.map { it.toDomain(allCountries) }
            Result.success(companies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCountries(): Result<List<Country>> {
        return try {
            val dtos = mongoDbClient.findAll("country", CountryDto::class.java)
            val countries = dtos.map { it.toDomain() }
            Result.success(countries)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

private fun CompanyDto.toDomain(countries: List<Country>): Company {
    val countryRef = countries.find { it.id == countryId }?.name ?: emptyList()

    return Company(
        id = _id,
        name = name,
        country = countryRef,
        foundedYear = foundedYear
    )
}

private fun CountryDto.toDomain(): Country = Country(
    id = _id,
    name = name
)
