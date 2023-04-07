plugins {
    kotlin("jvm") version "1.8.10"
    id("org.jetbrains.compose") version "1.3.1"
    id("dev.hydraulic.conveyor") version "1.4"
}

group = "com.example"
version = "1.0.3"
java.toolchain.languageVersion.set(JavaLanguageVersion.of(19))
compose.desktop.application.mainClass = "MainKt"

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    "linuxAmd64"(compose.desktop.linux_x64)
    "macAmd64"(compose.desktop.macos_x64)
    "macAarch64"(compose.desktop.macos_arm64)
    "windowsAmd64"(compose.desktop.windows_x64)
}

tasks{
    processResources {
        inputs.properties(Pair("version", version))
        expand(inputs.properties)
    }
}