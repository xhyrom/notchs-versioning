import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("idea")
    id("java")
    id("me.modmuss50.mod-publish-plugin") version "1.1.0"
    id("fabric-loom") version "1.14-SNAPSHOT" apply false
    id("net.neoforged.moddev") version "2.0.137" apply false
    id("com.gradleup.shadow") version "9.3.0" apply false
}

val baseName: String = property("archives_base_name") as String
val minecraftVersion: String = property("minecraft_version") as String

val modId: String = property("mod_id") as String
val modVersion: String = property("mod_version") as String
val modName: String = property("mod_name") as String
val modDescription: String = property("mod_description") as String

version = modVersion
group = "dev.xhyrom"

subprojects {
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    project.version = rootProject.version
    project.group = rootProject.group

    repositories {
        mavenCentral()
    }

    base {
        archivesName.set("${baseName}_${name}-${modVersion}+${minecraftVersion}")
    }

    tasks.processResources {
        inputs.property("version", modVersion)
        inputs.property("mod_name", modName)
        inputs.property("mod_description", modDescription)
        inputs.property("mod_id", modId)
        inputs.property("mod_version", modVersion)
        inputs.property("minecraft_version", minecraftVersion)

        filesMatching(listOf("META-INF/neoforge.mods.toml", "fabric.mod.json", "${modId}.*.mixins.json", "${modId}.mixins.json")) {
            expand(inputs.properties)
        }
    }

    if (name != "common") {
        tasks.named<ShadowJar>("shadowJar") {
            configurations = listOf(project.configurations.getByName("shadowBundle"))
            archiveFileName = "${base.archivesName.get()}.jar"
        }

        sourceSets.main {
            output.setResourcesDir(sourceSets.main.flatMap { it.java.classesDirectory })
            resources {
                srcDirs(project(":common").sourceSets["main"].resources)
            }
        }
    }

    tasks.withType(JavaCompile::class) {
        options.encoding = "UTF-8"
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25

        toolchain.languageVersion = JavaLanguageVersion.of(25)
    }
}