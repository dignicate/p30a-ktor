package com.dignicate.p30a.controller.automobile

import com.dignicate.p30a.controller.ApplicationCallWrapper
import com.dignicate.p30a.domain.automobile.Company
import com.dignicate.p30a.domain.automobile.GetCompaniesUseCase

class AutomobileController(
    private val call: ApplicationCallWrapper<List<Company>>,
    private val getCompaniesUseCase: GetCompaniesUseCase
) {
    suspend fun getCompanies(limit: Int, page: Int) {
        val companies = getCompaniesUseCase.execute(limit, page)
        call.respond(companies)
    }
}
