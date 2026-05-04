package com.dignicate.p30a.domain.di

import com.dignicate.p30a.domain.automobile.GetCompaniesUseCase
import com.dignicate.p30a.domain.currenttime.GetCurrentTimeUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { GetCompaniesUseCase(get()) }
    factory { GetCurrentTimeUseCase(get()) }
}
