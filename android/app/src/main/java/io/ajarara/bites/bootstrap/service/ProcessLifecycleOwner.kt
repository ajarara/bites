package io.ajarara.bites.bootstrap.service

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProcessLifecycleOwner @Inject constructor(
    private val application: Application
) : LifecycleOwner {

    override val lifecycle: Lifecycle by lazy {
        val wired = LifecycleRegistry(this)
        println("Ahmad initializing processLifecycleOwner.lifecycle")
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            private var activityCount = 0

            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {}

            override fun onActivityDestroyed(activity: Activity) {}

            override fun onActivityPaused(activity: Activity) {
                activityCount++
                if (activityCount == 0) {
                    wired.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                }
            }

            override fun onActivityResumed(activity: Activity) {
                activityCount--
                if (activityCount > 0) {
                    wired.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }
            }

            override fun onActivitySaveInstanceState(
                activity: Activity,
                outState: Bundle
            ) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

        })
        wired
    }

    fun init() {
        lifecycle // trigger initialization
    }
}