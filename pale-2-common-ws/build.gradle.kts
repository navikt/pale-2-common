val cxfVersion = "4.0.0"
val commonsCollectionVersion = "3.2.2"
plugins {
    id("java")
    id("maven-publish")
}

dependencies {
    api("commons-collections:commons-collections:$commonsCollectionVersion")
    api("org.apache.cxf:cxf-rt-frontend-jaxws:$cxfVersion")
    api("org.apache.cxf:cxf-rt-features-logging:$cxfVersion")
    api("org.apache.cxf:cxf-rt-transports-http:$cxfVersion")
    api("org.apache.cxf:cxf-rt-ws-security:$cxfVersion") {
        exclude(group = "org.apache.velocity", module = "velocity")
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
                name.set("pale-2-common-ws")
                description.set("Bibliotek for web-services implemenering i legeerklæring domenet")
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
