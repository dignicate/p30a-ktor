package com.dignicate.p30a.domain.automobile

class GetCompaniesUseCase(private val repository: AutomobileRepository) {
    suspend fun execute(limit: Int, page: Int): List<Company> {
        return repository.getCompanies(limit, page)
    }
}
