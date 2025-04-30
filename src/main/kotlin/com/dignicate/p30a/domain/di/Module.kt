package com.dignicate.p30a.domain.di

import com.dignicate.p30a.domain.automobile.GetCompaniesUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { GetCompaniesUseCase(get()) }
}
