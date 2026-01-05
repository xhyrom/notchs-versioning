plugins {
    idea
    id("net.neoforged.moddev")
    id("com.gradleup.shadow")
}

val shadowBundle: Configuration by configurations.creating

neoForge {
    version = property("neoforge_version") as String

    runs {
        create("client") {
            client()
        }

        create("server") {
            server()
            programArgument("--nogui")
        }
    }

    mods {
        create(property("mod_id") as String) {
            sourceSet(sourceSets.main.get())
        }
    }
}

dependencies {
    implementation(project(":common"))
    shadowBundle(project(":common"))
}

tasks.build {
    dependsOn(tasks.named("shadowJar"))
}

tasks.jar {
    archiveFileName = "${base.archivesName.get()}.jar"
}
