plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
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
            allDevices {
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
    
    implementation("com.google.guava:guava:${Versions.guava}")
    implementation("androidx.room:room-runtime:${Versions.room}")
    implementation("androidx.appcompat:appcompat:${Versions.appCompat}")
    implementation("com.google.dagger:dagger-android:${Versions.dagger}")
    implementation("com.google.dagger:dagger-android-support:${Versions.dagger}") // if you use the support libraries
    annotationProcessor("com.google.dagger:dagger-android-processor:${Versions.dagger}")
    annotationProcessor("androidx.room:room-compiler:${Versions.room}")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

    // Testing-only dependencies
    androidTestImplementation("androidx.test:core:${Versions.core}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.extJUnit}")
    androidTestImplementation("androidx.test:runner:${Versions.runner}")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutinesTest}")

    // UiAutomator Testing
    androidTestImplementation("androidx.test.uiautomator:uiautomator:${Versions.uiAutomator}")
    androidTestImplementation("org.hamcrest:hamcrest-integration:1.3")
}
