package io.ajarara.bites.bootstrap.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.ajarara.bites.bootstrap.service.ProcessLifecycleOwner
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class BitesApplication : Application() {

    @Inject
    lateinit var processLifecycleOwner: ProcessLifecycleOwner
    @Inject
    lateinit var mainScope: CoroutineScope

    override fun onCreate() {
        super.onCreate()
        processLifecycleOwner.init()
    }
}

