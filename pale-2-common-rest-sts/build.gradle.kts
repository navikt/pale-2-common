val ktorVersion = "1.3.1"
val jacksonVersion = "2.9.8"

repositories {
    maven(url = "https://kotlin.bintray.com/kotlinx")
}

plugins {
    id("java")
    id("maven-publish")
    id("org.sonarqube") version "2.7"
}

dependencies {
    implementation("io.ktor:ktor-client-apache:$ktorVersion")
    implementation("io.ktor:ktor-client-jackson:$ktorVersion")
    implementation("io.ktor:ktor-client-auth-jvm:$ktorVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
}

subprojects {
    properties["sonarHost"]?.let { host ->
        sonarqube {
            properties {
                property("sonar.sourceEncoding", "UTF-8")
                property("sonar.host.url", host)
            }
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/navikt/pale-2-common")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {

            pom {
                name.set("syfoam-common-rest-sts")
                description.set("Bibliotek for rest sts oppsett for legeerklæring domentet")
                url.set("https://github.com/navikt/pale-2-common")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/navikt/pale-2-common.git")
                    developerConnection.set("scm:git:https://github.com/navikt/pale-2-common.git")
                    url.set("https://github.com/navikt/pale-2-common")
                }
            }
            from(components["java"])
        }
    }
}