import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    idea
    id("net.fabricmc.fabric-loom")
    id("com.gradleup.shadow")
}

val shadowBundle: Configuration by configurations.creating

val loom = project.extensions.getByName<LoomGradleExtensionAPI>("loom")

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    implementation("net.fabricmc:fabric-loader:${property("fabric_loader_version")}")
    implementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")

    implementation(project(":common"))
    shadowBundle(project(":common"))
}

tasks.build {
    dependsOn(tasks.named("shadowJar"))
}

tasks.jar {
    archiveFileName = "${base.archivesName.get()}.jar"
}
