package com.dignicate.p30a.data.di

import com.dignicate.p30a.data.automobile.AutomobileRepositoryImpl
import com.dignicate.p30a.data.automobile.CountryDataStore
import com.dignicate.p30a.data.common.MongoDbClientWrapper
import com.dignicate.p30a.data.di.config.DatabaseConfig
import com.dignicate.p30a.domain.automobile.AutomobileRepository
import org.koin.dsl.module


val dataModule = module {
    single { CountryDataStore() }
    single<AutomobileRepository> { AutomobileRepositoryImpl(get(), get()) }
}

val databaseModule = module {
    single {
        MongoDbClientWrapper(
            connectionString = DatabaseConfig.Mongo.connection.connectionString,
            databaseName = DatabaseConfig.Mongo.connection.databaseName
        )
    }
}
