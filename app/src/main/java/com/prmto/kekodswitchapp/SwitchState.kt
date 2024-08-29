package com.prmto.kekodswitchapp

import com.prmto.kekodswitchapp.switch_main.Emotion

data class SwitchState(
    val emotion: Emotion,
    val isSwitchChecked: Boolean
)