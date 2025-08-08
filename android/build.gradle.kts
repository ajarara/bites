// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val agpVersion = "8.5.0"
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:$agpVersion")
    }
}

allprojects {
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
}

extra["buildToolsVersion"] = "32.0.0"
extra["androidxAnnotationVersion"] = "1.5.0"
extra["guavaVersion"] = "31.1-android"
extra["coreVersion"] = "1.6.1"
extra["extJUnitVersion"] = "1.2.1"
extra["runnerVersion"] = "1.6.1"
extra["rulesVersion"] = "1.6.1"
extra["espressoVersion"] = "3.6.1"
extra["uiAutomatorVersion"] = "2.3.0"
