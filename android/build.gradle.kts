// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val kotlin_version by extra("2.2.0")
    val agpVersion = "8.11.1"
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:$agpVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
}

val buildToolsVersion by extra("32.0.0")
val androidxAnnotationVersion by extra("1.5.0")
val guavaVersion by extra("31.1-android")
val coreVersion by extra("1.6.1")
val extJUnitVersion by extra("1.2.1")
val runnerVersion by extra("1.6.1")
val rulesVersion by extra("1.6.1")
val espressoVersion by extra("3.6.1")
val uiAutomatorVersion by extra("2.3.0")
