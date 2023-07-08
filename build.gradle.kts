plugins {
    kotlin("jvm") version "1.9.0"
}

group = "com.daisuzz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.arrow-kt:arrow-core:1.2.0-RC")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0-RC")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
