package com.dignicate.p30a.data.di.config

import java.io.File
import java.util.Properties

object DatabaseConfig {

    object Mongo {
        private val properties = Properties()

        val connection: MongoConnectionConfig

        init {
            val env = System.getenv("ENV") ?: "dev"
            val configFile = File("env/$env/mongo.properties")
            if (configFile.exists()) {
                configFile.inputStream().use { properties.load(it) }
            } else {
                throw RuntimeException("Properties file not found: ${configFile.absolutePath}")
            }

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
