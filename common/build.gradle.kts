plugins {
    idea
    id("net.neoforged.moddev")
}

neoForge {
    neoFormVersion = property("neoform_version") as String
}

repositories {
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
    compileOnly("org.spongepowered:mixin:0.8.5-SNAPSHOT")
}