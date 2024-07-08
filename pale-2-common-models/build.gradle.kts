val jacksonVersion = "2.17.2"

plugins {
    id("java")
    id("maven-publish")
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
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
                name.set("pale-2-common-models")
                description.set("Bibliotek for felles domene modeller for legeerklærings domenet")
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
