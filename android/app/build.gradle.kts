plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.android.testing.uiautomator.BasicSample"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    productFlavors {
        // No product flavors defined in the original, but this block is kept for completeness.
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        managedDevices {
            devices {
                // run with ../gradlew nexusOneApi30DebugAndroidTest
                create<com.android.build.api.dsl.ManagedVirtualDevice>("nexusOneApi30") {
                    // A lower resolution device is used here for better emulator performance
                    device = "Nexus One"
                    apiLevel = 30
                    // Also use the AOSP ATD image for better emulator performance
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }
    namespace = "com.example.android.testing.uiautomator.BasicSample"
    testNamespace = "com.example.android.testing.uiautomator.BasicSample.test"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.16.0")
    
    implementation("com.google.guava:guava:${Versions.guavaVersion}")

    // Testing-only dependencies
    androidTestImplementation("androidx.test:core:${Versions.coreVersion}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.extJUnitVersion}")
    androidTestImplementation("androidx.test:runner:${Versions.runnerVersion}")

    // UiAutomator Testing
    androidTestImplementation("androidx.test.uiautomator:uiautomator:${Versions.uiAutomatorVersion}")
    androidTestImplementation("org.hamcrest:hamcrest-integration:1.3")
}
