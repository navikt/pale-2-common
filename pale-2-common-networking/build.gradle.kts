val coroutinesVersion = "1.6.1"
val logbackVersion = "1.2.11"
val logstashEncoderVersion = "7.1.1"


plugins {
    id("java")
    id("maven-publish")
}

dependencies {
    implementation(project(":pale-2-common-metrics"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashEncoderVersion")
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
                name.set("syfoam-common-networking")
                description.set("Bibliotek for standar nettverksoppsett for legeerklæring domentet")
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
