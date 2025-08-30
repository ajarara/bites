buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.agp}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${Versions.composeCompilerGradlePlugin}")
    }
}

plugins {
    id("com.google.devtools.ksp") version "${Versions.kotlin}-2.0.2" apply false
}

allprojects {
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
}
