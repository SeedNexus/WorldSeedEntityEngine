plugins {
    id("java")
    `maven-publish`
    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

publishing {
    publications.create<MavenPublication>("maven") {
        groupId = "net.worldseed.multipart"
        artifactId = "WorldSeedEntityEngine"
        version = "10.0.3"

        from(components["java"])
    }

    repositories {
        maven {
            name = "WorldSeed"
            url = uri("https://reposilite.worldseed.online/public")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("net.minestom:minestom-snapshots:aad7bdab0f")

    implementation("commons-io:commons-io:2.11.0")
    implementation("org.zeroturnaround:zt-zip:1.8")

    implementation(files("libs/caliko-1.3.8.jar"))
    implementation(files("libs/caliko-visualisation-1.3.8.jar"))

    implementation("org.lwjgl:lwjgl:3.2.2")
    implementation("org.lwjgl:lwjgl-glfw:3.2.2")
    implementation("org.lwjgl:lwjgl-opengl:3.2.2")

    implementation("org.lwjgl:lwjgl:3.3.3:natives-linux")
    implementation("org.lwjgl:lwjgl-glfw:3.3.3:natives-linux")
    implementation("org.lwjgl:lwjgl-opengl:3.3.3:natives-linux")

    implementation("javax.json:javax.json-api:1.1.4")
    implementation("org.glassfish:javax.json:1.1.4")

    implementation("com.github.hollow-cube.common:mql:2b48ad430f")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
