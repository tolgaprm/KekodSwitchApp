package com.prmto.kekodswitchapp.alarm

import java.time.LocalDateTime

interface AlarmScheduler {
    fun scheduleAlarm(alarmItem: AlarmItem)
    fun cancelAlarm(alarmItem: AlarmItem)
}

data class AlarmItem(
    val alarmId: Int,
    val alarmTitle: String,
    val alarmMessage: String,
    val alarmTime: LocalDateTime
)