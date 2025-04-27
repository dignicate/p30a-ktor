package com.dignicate.p30a.data.di

import com.dignicate.p30a.data.automobile.AutomobileRepositoryImpl
import com.dignicate.p30a.data.common.MongoDbClientWrapper
import com.dignicate.p30a.domain.automobile.AutomobileRepository
import org.koin.dsl.module


val dataModule = module {
//    single<AutomobileRepository> { MockAutomobileRepository() }
    single<AutomobileRepository> { AutomobileRepositoryImpl(get()) }
}

val databaseModule = module {
    single {
        MongoDbClientWrapper(
            connectionString = "mongodb://user:pass@host",
            databaseName = "your_database"
        )
    }
}
