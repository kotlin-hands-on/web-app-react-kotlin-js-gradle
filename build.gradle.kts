plugins {
    id("org.jetbrains.kotlin.js") version "1.5.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }
}

dependencies {

    //React, React DOM + Wrappers (chapter 3)
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.231-kotlin-1.5.21")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.231-kotlin-1.5.21")
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-dom", "17.0.2"))

    //Kotlin Styled (chapter 3)
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.0-pre.231-kotlin-1.5.21")
    implementation(npm("styled-components", "~5.3.0"))

    //Video Player (chapter 7)
    implementation(npm("react-youtube-lite", "1.0.1"))

    //Share Buttons (chapter 7)
    implementation(npm("react-share", "~4.2.1"))

    //Coroutines (chapter 8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-RC")
}

// Heroku Deployment (chapter 9)
tasks.register("stage") {
    dependsOn("build")
}

//fix for webpack issue from https://youtrack.jetbrains.com/issue/KT-48273#focus=Comments-27-5122487.0-0
rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpackDevServer.version = "4.0.0-rc.0"
}
