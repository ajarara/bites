package io.ajarara.bites.bootstrap.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.HiltAndroidApp
import io.ajarara.bites.bootstrap.foreground.ReentryService
import io.ajarara.bites.bootstrap.service.ProcessLifecycleOwner
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class BitesApplication : Application() {

    @Inject
    lateinit var processLifecycleOwner: ProcessLifecycleOwner

    @Inject
    lateinit var applicationScope: CoroutineScope

    override fun onCreate() {
        super.onCreate()
        println("Ahmad $this#onCreate")
        processLifecycleOwner.init()

    }
}

