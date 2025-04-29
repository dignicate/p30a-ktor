package com.dignicate.p30a.data.automobile

import com.dignicate.p30a.domain.automobile.LocalizedString

data class CompanyDto(
    val _id: Int,
    val name: List<LocalizedString>,
    val countryId: Int,
    val foundedYear: Int
)

data class CountryDto(
    val _id: Int,
    val name: List<LocalizedString>
)
