pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://maven.minecraftforge.net/")
    }
}

rootProject.name = "notchs-versioning"
include("common")
include("neoforge")
include("fabric")