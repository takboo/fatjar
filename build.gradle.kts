plugins {
    id("groovy")
    id("maven-publish")
}

repositories {
    google()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.github.ab180"
            artifactId = "fatjar"
            version = "1.8.0"
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
}