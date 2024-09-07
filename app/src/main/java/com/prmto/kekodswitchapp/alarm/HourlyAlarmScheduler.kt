package com.prmto.kekodswitchapp.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.time.ZoneId

class HourlyAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private fun createPendingIntent(alarmItem: AlarmItem): PendingIntent {
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(EXTRA_TITLE, alarmItem.alarmTitle)
            putExtra(EXTRA_MESSAGE, alarmItem.alarmMessage)
        }
        return PendingIntent.getBroadcast(
            context,
            alarmItem.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    override fun scheduleAlarm(alarmItem: AlarmItem) {
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            alarmItem.alarmTime.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000,
            AlarmManager.INTERVAL_HOUR,
            createPendingIntent(alarmItem)
        )
    }

    override fun cancelAlarm(alarmItem: AlarmItem) {
        // Cancel alarm
    }


    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val EXTRA_TITLE = "extra_title"
    }
}