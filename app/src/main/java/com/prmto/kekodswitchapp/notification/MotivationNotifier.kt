package com.prmto.kekodswitchapp.notification

import android.app.Notification
import android.app.NotificationManager
import android.content.Context

class MotivationNotifier(
    private val context: Context,
    private val notificationManager: NotificationManager
) : Notifier(notificationManager) {
    override val notificationChannelId: String
        get() = "daily_notification_channel"
    override val notificationChannelName: String
        get() = "Daily Notification Channel"
    override val notificationId: Int
        get() = 1000

    override fun buildNotification(
        notificationTitle: String,
        notificationMessage: String
    ): Notification {
        return Notification.Builder(context, notificationChannelId)
            .setContentTitle(notificationTitle)
            .setContentText(notificationMessage)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .build()
    }
}