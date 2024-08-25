@file:Suppress("UnstableApiUsage")

rootProject.name = "spring-demo"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

//plugins {
//    id("org.gradle.toolchains")
//}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/central")
    }
}

include("spring-web")
include("spring-reactive-web")
include("spring-datasource")
include("spring-rabbitmq")
include("spring-redis")
include("spring-mybatis")
include("spring-graphql")
include("commons")


println("SETTINGS FILE: This is executed during the initialization phase")