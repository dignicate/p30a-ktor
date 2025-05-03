package com.dignicate.p30a.controller.automobile

import com.dignicate.p30a.domain.automobile.Company
import com.dignicate.p30a.domain.automobile.GetCompaniesUseCase

class AutomobileController(
    private val getCompaniesUseCase: GetCompaniesUseCase
) {
    suspend fun getCompanies(limit: Int, page: Int): List<Company> {
        return getCompaniesUseCase.execute(limit, page)
    }
}
