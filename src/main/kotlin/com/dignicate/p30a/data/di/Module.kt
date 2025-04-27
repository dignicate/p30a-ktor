package com.dignicate.p30a.data.di

import com.dignicate.p30a.domain.automobile.AutomobileRepository
import com.dignicate.p30a.domain.automobile.MockAutomobileRepository
import org.koin.dsl.module


val dataModule = module {
    single<AutomobileRepository> { MockAutomobileRepository() }
}
