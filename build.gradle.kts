
val kotlin_version: String by project
val logback_version: String by project
val ktor_version: String by project

plugins {
    kotlin("jvm") version "1.9.24"
    id("io.ktor.plugin") version "2.3.12"
    kotlin("plugin.serialization") version "1.4.21"
}

group = "com.dignicate"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
    applicationName = "ktor-app"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // https://ktor.io/docs/server-resources.html
    implementation("io.ktor:ktor-server-resources:$ktor_version")

    // https://ktor.io/docs/server-serialization.html
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    // koin
    implementation("io.insert-koin:koin-ktor:3.3.0")

    // Swagger UI
    implementation("io.ktor:ktor-server-swagger:$ktor_version")
    implementation("io.ktor:ktor-server-cors:$ktor_version")

    // MongoDB
    implementation(platform("org.mongodb:mongodb-driver-bom:5.4.0"))
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine")

}
