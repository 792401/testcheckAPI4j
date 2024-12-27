/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.9.1/userguide/building_java_projects.html
 */
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

plugins {
    `java-library`
    id("io.freefair.aspectj.post-compile-weaving") version "8.6"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(project(":lib"))
    implementation("org.aspectj:aspectjrt:1.9.22")
    implementation("org.aspectj:aspectjweaver:1.9.22")
    implementation("io.rest-assured:rest-assured:5.3.0")
    implementation("io.rest-assured:json-path:5.3.0")
    compileOnly("org.aspectj:aspectjtools:1.9.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    compileOnly("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:29.0-jre")
    implementation("org.slf4j:slf4j-api:2.0.9")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.json:json:20230227") // JSON processing library
}

tasks.test {
    useJUnitPlatform()
    jvmArgs(
            "-javaagent:${configurations.compileClasspath.get().find { it.name.contains("aspectjweaver") }?.absolutePath}",
//            "-Daj.weaving.verbose=true",
//            "-Dorg.aspectj.weaver.showWeaveInfo=true",
//            "-Dorg.aspectj.matcher.verbosity=5"
            "-Xmx2g", // Increase maximum heap size to 2GB
            "-Xms512m" // Set initial heap size to 512MB
    )
}
