plugins {
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "nulled"
version = "1.0"

repositories {
    mavenCentral()

    maven {
        url = uri("https://maven.pkg.github.com/zeruth/logger")
        credentials {
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}

dependencies {
    with(libs) {
        implementation(kotlin.coroutines)
        implementation(kotlin.logging)
    }
    implementation("nulled:logger:1.0")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/zeruth/annotations")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}