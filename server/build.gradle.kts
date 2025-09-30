plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "org.lyd.kmp01"
version = "1.0.0"
application {
    mainClass.set("org.lyd.kmp01.ApplicationKt")
    
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(projects.shared)
    implementation(project.dependencies.platform(libs.ktor.bom))
    implementation(libs.ktor.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.json)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.testJunit)
}