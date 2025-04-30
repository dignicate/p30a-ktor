package com.dignicate.p30a.data.di.config

data class MongoConnectionConfig(
    val hosts: List<HostInfo>,
    val replicaSetName: String?,
    val databaseName: String
) {
    data class HostInfo(
        val host: String,
        val port: Int
    )

    val connectionString: String
        get() {
            val hostList = hosts.joinToString(",") { "${it.host}:${it.port}" }
            var connStr = "mongodb://$hostList"
            if (!replicaSetName.isNullOrBlank()) {
                connStr += "/?replicaSet=$replicaSetName"
            }
            return connStr
        }

    override fun toString(): String {
        return "MongoConnectionConfig(hosts=$hosts, database=$databaseName)"
    }
}
