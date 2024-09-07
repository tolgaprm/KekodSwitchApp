package com.prmto.kekodswitchapp.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.prmto.kekodswitchapp.alarm.HourlyAlarmScheduler.Companion.EXTRA_MESSAGE
import com.prmto.kekodswitchapp.alarm.HourlyAlarmScheduler.Companion.EXTRA_TITLE
import com.prmto.kekodswitchapp.notification.MotivationNotifier
import com.prmto.kekodswitchapp.notification.Notifier

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val notifier: Notifier = MotivationNotifier(
                context = context,
                notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
            )

            val title = intent?.getStringExtra(EXTRA_TITLE) ?: return
            val message = intent.getStringExtra(EXTRA_MESSAGE) ?: return
            context?.let {
                notifier.showNotification(
                    title,
                    message
                )
            }
        }
    }
}