val kotlinVersion = "1.9.23"
val junitJupiterVersion = "5.10.2"
val javaVersion = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.9.22"
}

allprojects {
    group = "no.nav.syfo"
    version = properties["version"] ?: "local-build"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")

    }

    tasks {

        compileKotlin {
            kotlinOptions.jvmTarget = javaVersion.toString()
        }

        compileTestKotlin {
            kotlinOptions.jvmTarget = javaVersion.toString()
        }

        test {
            useJUnitPlatform {}
            testLogging {
                events("skipped", "failed")
                showStackTraces = true
                exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            }
        }
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}
