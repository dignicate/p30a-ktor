package com.dignicate.p30a.domain.automobile

class GetCompaniesUseCase(private val repository: AutomobileRepository) {
    suspend fun execute(limit: Int, page: Int): List<Company> {
        if (limit < 1) throw IllegalArgumentException("limit must be > 0")
        if (page < 1) throw IllegalArgumentException("page must be > 0")

        return repository.getCompanies(limit, page).fold(
            onSuccess = { it },
            onFailure = { throw it }
        )
    }
}
