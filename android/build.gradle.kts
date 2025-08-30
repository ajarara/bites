buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.agpVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath("org.jetbrains.kotlin:compose-compiler-gradle-plugin:${Versions.composeCompilerGradlePlugin}")
    }
}

allprojects {
    repositories {
        // Insert local test repo here
        google()
        mavenCentral()
    }
}
