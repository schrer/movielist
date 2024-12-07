plugins {
    id("java")
    id("io.freefair.lombok") version "8.11"
}

group = "at.schrer"
version = "1.0-SNAPSHOT"

val javalinVersion = "6.3.0"
val injectVersion = "1.0.0"
val junitVersion = "5.10.0"
val slf4jSimpleVersion = "2.0.16"
val jacksonVersion = "2.17.2"
val jetBrainsAnnotationVersion = "26.0.1"
val httpClientVersion = "5.4.1"

repositories {
    mavenCentral()
    mavenLocal()
}

java {
    modularity.inferModulePath = true
}

dependencies {
    implementation("io.javalin:javalin:$javalinVersion")
    implementation("at.schrer:inject:$injectVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jSimpleVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("org.apache.httpcomponents.client5:httpclient5:$httpClientVersion")
    implementation("org.jetbrains:annotations:$jetBrainsAnnotationVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}