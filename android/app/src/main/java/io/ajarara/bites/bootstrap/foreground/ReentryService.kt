package io.ajarara.bites.bootstrap.foreground

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import io.ajarara.bites.bootstrap.activity.ObscuringActivity

class ReentryService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("Ahmad $this#onCreate")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    "Reentry-name",
                    NotificationManager.IMPORTANCE_HIGH,
                ).apply {
                    description = "Reentry description!"
                }
            )
        }

        startForeground(NOTIFICATION_ID,
            NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Foreground service")
                .setContentText("Service is running")
                .setOngoing(true)
                .setSmallIcon(android.R.drawable.ic_popup_sync)
                .build())
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Ahmad $this#onDestroy")
    }

    companion object {
        const val NOTIFICATION_ID = 1
        const val CHANNEL_ID = "foreground_service_channel"
    }
}