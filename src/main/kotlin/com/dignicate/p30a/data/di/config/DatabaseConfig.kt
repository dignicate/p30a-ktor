package com.dignicate.p30a.data.di.config

import java.io.File
import java.util.Properties

object DatabaseConfig {

    object Mongo {
        private val properties = Properties()

        val connection: MongoConnectionConfig

        init {
            val inputStream = this::class.java.classLoader.getResourceAsStream("mongo.properties")
                ?: throw RuntimeException("mongo.properties not found in classpath")
            properties.load(inputStream)

            val hosts = mutableListOf<MongoConnectionConfig.HostInfo>()
            for (i in 1..5) {
                val host = properties.getProperty("mongo.host$i.url") ?: continue
                val port = properties.getProperty("mongo.host$i.port")?.toIntOrNull() ?: 27017
                hosts.add(MongoConnectionConfig.HostInfo(host, port))
            }

            if (hosts.isEmpty()) {
                throw RuntimeException("No MongoDB hosts defined in properties")
            }

            val replicaSetName = properties.getProperty("mongo.replicaSetName")
            val databaseName = properties.getProperty("mongo.database")
                ?: throw RuntimeException("mongo.database is not set")

            connection = MongoConnectionConfig(
                hosts = hosts,
                replicaSetName = replicaSetName,
                databaseName = databaseName
            )
        }
    }
}
