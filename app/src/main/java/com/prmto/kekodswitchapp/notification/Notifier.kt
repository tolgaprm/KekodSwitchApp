package com.prmto.kekodswitchapp.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager

abstract class Notifier(
    private val notificationManager: NotificationManager
) {
    abstract val notificationChannelId: String
    abstract val notificationChannelName: String
    abstract val notificationId: Int

    fun showNotification(
        notificationTitle: String,
        notificationMessage: String
    ) {
        val channel = createNotificationChannel()
        val notification = buildNotification(notificationTitle, notificationMessage)
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(
            notificationId,
            notification
        )
    }

    protected open fun createNotificationChannel(
        importance: Int = NotificationManager.IMPORTANCE_DEFAULT
    ): NotificationChannel {
        return NotificationChannel(
            notificationChannelId,
            notificationChannelName,
            importance
        )
    }

    protected abstract fun buildNotification(
        notificationTitle: String,
        notificationMessage: String
    ): Notification
}