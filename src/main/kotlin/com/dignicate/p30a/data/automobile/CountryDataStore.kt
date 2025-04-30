package com.dignicate.p30a.data.automobile

import com.dignicate.p30a.domain.automobile.Country

class CountryDataStore {
    private var cachedCountries: List<Country>? = null

    suspend fun getOrLoad(loader: suspend () -> Result<List<Country>>): Result<List<Country>> {
        if (cachedCountries != null) return Result.success(cachedCountries!!)
        return loader().onSuccess { countries ->
            cachedCountries = countries
        }
    }
}
