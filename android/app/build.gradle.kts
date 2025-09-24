plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "io.ajarara.bites.bootstrap"
    compileSdk = 36

    defaultConfig {
        applicationId = "io.ajarara.bites.bootstrap"
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    namespace = "io.ajarara.bites.bootstrap"
    testNamespace = "io.ajarara.bites.bootstrap.test"
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":septa"))
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.retrofit)
    implementation(libs.recyclerview)
    implementation(libs.recyclerview.selection)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    
}
