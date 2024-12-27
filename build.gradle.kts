plugins {
    kotlin("jvm") version "2.0.21"
}

group = "jp.hisano"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.failsafe:failsafe:3.3.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}