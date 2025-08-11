/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.testing.uiautomator.BasicSample

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class ChangeTextBehaviorTest {
    private var mDevice: UiDevice? = null

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        mDevice!!.pressHome()

        // Wait for launcher
        val launcherPackage = launcherPackageName
        Assert.assertThat(launcherPackage, CoreMatchers.notNullValue())
        mDevice!!.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT.toLong())

        // Launch the blueprint app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager
            .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Clear out any previous instances
        context.startActivity(intent)

        // Wait for the app to appear
        mDevice!!.wait(
            Until.hasObject(
                By.pkg(
                    BASIC_SAMPLE_PACKAGE
                ).depth(0)
            ), LAUNCH_TIMEOUT.toLong()
        )
    }

    @Test
    fun checkPreconditions() {
        Assert.assertThat(mDevice, CoreMatchers.notNullValue())
    }

    @Test
    fun testChangeText_sameActivity() {
        // Type text and then press the button.
        mDevice!!.findObject(
            By.res(
                BASIC_SAMPLE_PACKAGE,
                "editTextUserInput"
            )
        ).text = STRING_TO_BE_TYPED
        mDevice!!.findObject(By.res(BASIC_SAMPLE_PACKAGE, "changeTextBt"))
            .click()

        // Verify the test is displayed in the Ui
        val changedText = mDevice!!
            .wait(
                Until.findObject(
                    By.res(
                        BASIC_SAMPLE_PACKAGE, "textToBeChanged"
                    )
                ),
                500 /* wait 500ms */
            )
        Assert.assertThat(
            changedText.text, CoreMatchers.`is`(
                CoreMatchers.equalTo(
                    STRING_TO_BE_TYPED
                )
            )
        )
    }

    @Test
    fun testChangeText_newActivity() {
        // Type text and then press the button.
        mDevice!!.findObject(
            By.res(
                BASIC_SAMPLE_PACKAGE,
                "editTextUserInput"
            )
        ).text = STRING_TO_BE_TYPED
        mDevice!!.findObject(By.res(BASIC_SAMPLE_PACKAGE, "activityChangeTextBtn"))
            .click()

        // Verify the test is displayed in the Ui
        val changedText = mDevice!!
            .wait(
                Until.findObject(
                    By.res(
                        BASIC_SAMPLE_PACKAGE, "show_text_view"
                    )
                ),
                500 /* wait 500ms */
            )
        Assert.assertThat(
            changedText.text, CoreMatchers.`is`(
                CoreMatchers.equalTo(
                    STRING_TO_BE_TYPED
                )
            )
        )
    }

    private val launcherPackageName: String
        /**
         * Uses package manager to find the package name of the device launcher. Usually this package
         * is "com.android.launcher" but can be different at times. This is a generic solution which
         * works on all platforms.`
         */
        get() {
            // Create launcher Intent
            val intent =
                Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)

            // Use PackageManager to get the launcher package name
            val pm =
                ApplicationProvider.getApplicationContext<Context>()
                    .packageManager
            val resolveInfo =
                pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
            return resolveInfo!!.activityInfo.packageName
        }

    companion object {
        private const val BASIC_SAMPLE_PACKAGE =
            "com.example.android.testing.uiautomator.BasicSample"

        private const val LAUNCH_TIMEOUT = 5000

        private const val STRING_TO_BE_TYPED = "UiAutomator"
    }
}
