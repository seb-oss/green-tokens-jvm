import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version "2.2.0"
    id("com.vanniktech.maven.publish") version "0.34.0"
    id("org.jetbrains.dokka") version "1.9.0"
}

group = "io.github.sebopensource"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.vanniktech.maven.publish:0.34.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

mavenPublishing {
    configure(KotlinJvm(
        javadocJar = JavadocJar.Dokka("dokkaHtml"),
        sourcesJar = true
    ))
}