plugins {
    id("groovy")
    id("maven-publish")
}

repositories {
    google()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.github.takboo"
            artifactId = "fatjar"
            version = "1.8.2"
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri("$buildDir/maven")
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation("com.android.tools.build:gradle:8.0.2")
    implementation("org.zeroturnaround:zt-zip:1.16")
    implementation("io.github.g00fy2:versioncompare:1.5.0")
    implementation(fileTree(mapOf("dir" to "libs", "include" to "jarjar*.jar")))
}