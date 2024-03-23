plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    id("maven-publish")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "main"
            isStatic = true
        }
    }

    sourceSets.commonMain.dependencies {
        api(project(":auth"))
        api(project(":diary"))
        api(project(":shared"))
        api(project(":introduction"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.bodzio6978"
            artifactId = "fitness-app-common"
            version = "1.7"
        }
    }
}

android {
    namespace = "com.gmail.bogumilmecel2.main"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}