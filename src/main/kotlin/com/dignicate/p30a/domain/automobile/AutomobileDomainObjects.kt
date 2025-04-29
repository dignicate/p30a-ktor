package com.dignicate.p30a.domain.automobile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: List<LocalizedString>,
    @SerialName("country")
    val country: List<LocalizedString>,
    @SerialName("founded_year")
    val foundedYear: Int
)

@Serializable
data class LocalizedString(
    @SerialName("language")
    val language: String,
    @SerialName("value")
    val value: String
)

data class Country(
    val id: Int,
    val name: List<LocalizedString>
)
